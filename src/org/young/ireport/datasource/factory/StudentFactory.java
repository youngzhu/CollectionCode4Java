package org.young.ireport.datasource.factory;

import java.util.ArrayList;
import java.util.Collection;

import org.young.ireport.datasource.javabean.NativePlace;
import org.young.ireport.datasource.javabean.Student;
import org.young.ireport.datasource.util.StudentUtil;

/**
 * 生成JavaBean的工厂类。
 * 在iReport的DataSource的配置中会用到。
 *
 * @author by Young.ZHU
 *                on 2012-8-3
 *
 * Package&FileName: ds.javabean.StudentFactory
 */
public class StudentFactory {
    //~ Static fields/initializers *********************************************

    // 生成实体对象的个数
    private static final int RECORD_COUNT = 100;

    //~ Methods ****************************************************************

    /**
     * 这个方法在iReport的DataResource配置时也会用到
     * 必须是静态方法 static
     *
     * @return
     */
    public static Collection<Student> createBeanCollection() {
        Collection<Student> beanCollection = new ArrayList<Student>();

        for (int i = 0; i < RECORD_COUNT; i++) {
        	Student stu = StudentUtil.createStudent(i + 1);
        	
        	NativePlace np = new NativePlace();
        	np.setProvince("江苏");
        	np.setCity("南京");
        	
        	stu.setNativePlace(np);
            beanCollection.add(stu);
        }

        return beanCollection;
    }
}
