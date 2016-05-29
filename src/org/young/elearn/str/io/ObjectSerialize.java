package org.young.elearn.str.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象的序列化
 *
 * @author by Young.ZHU
 *      on 2016年5月29日
 *
 * Package&FileName: org.young.elearn.str.io.ObjectSerialize
 */
public abstract class ObjectSerialize {

	/**
	 * 将对象存储到文件中
	 * 
	 * @param obj - 要存储的对象
	 * @param destFile - 存储的文件名
	 * @throws IOException 
	 */
	public static void writeObject(Object obj, String destFile) {
		// 如果目录不存在，则创建
		String pathStr = destFile.substring(0, destFile.lastIndexOf("\\"));
		// System.out.println(pathStr);
		File pathObj = new File(pathStr);
		if (!pathObj.exists()) {
			pathObj.mkdir();
		}
		
		File file = new File(destFile);

		// 放在try里会自动关闭（close）资源
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			oos.writeObject(obj);
			System.out.println("object written.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从文件中读取对象
	 * 
	 * @param sourceFile - 存储对象信息的文件
	 * @return
	 */
	public static Object readObject(String sourceFile) {
		Object obj = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sourceFile));) {
			obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}
}
