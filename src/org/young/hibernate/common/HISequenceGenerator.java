package org.young.hibernate.common;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.id.SequenceGenerator;

/**
 * 继承 hibernate 里的 SequenceGenerator 类，
 * 覆写2个方法：
 * 	1. buildHolder()
 * 	2. generate(SessionImplementor session, Object obj)
 *
 * @author by youngz
 *      on 2016年7月24日
 *
 * Package&FileName: org.young.hibernate.common.HISequenceGenerator
 */
public class HISequenceGenerator extends SequenceGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object obj) {
		
		/*
		 * 源码
		 * 
		 * return generateHolder(session).makeValue();
		 */
//		Serializable id = generateHolder(session).makeValue();
		Number id = generateHolder(session).makeValue();
		
		/*
		 * 笔者曾自作聪明地以为可以省掉这一步，
		 * 继而这个方法就不用覆写，毕竟都是 Serializable ，
		 * 不管是数字（Number）还是字符串（String）
		 * 
		 * 但返回值却需要确定到String，因为Java类（hbm对象）的属性是String类型的
		 * 而 makeValue() 返回的 Number （这里的实际类型是 Long）
		 * 
		 * 所以 id 的类型直接定义成 Number （更直观），
		 * 而不是 Serializable
		 */
        if (getIdentifierType().getReturnedClass() == String.class){
        	//增加对String的判断
            return id.toString();
        }
        
        return id;
	}

	@Override
	protected IntegralDataTypeHolder buildHolder() {
		/*
		 * 源码
		 * 
		 * return IdentifierGeneratorHelper.getIntegralDataTypeHolder(this.identifierType.getReturnedClass());
		 */
		return HIIdentifierGeneratorHelper
				.getIntegralDataTypeHolder(getIdentifierType()
						.getReturnedClass());
	}
}
