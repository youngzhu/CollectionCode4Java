package org.young.ireport.datasource.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;

import org.young.ireport.datasource.javabean.Student;

/**
 * 随机生成Student实体对象的工具类
 *
 * @author by Young.ZHU
 *                on 2012-8-3
 *
 * Package&FileName: ds.javabean.StudentUtil
 */
public class StudentUtil {
    //~ Static fields/initializers *********************************************

    /*
     * “姓”的字符数组
     */
    private static String[] FIRST_NAME_ARR = {
            "赵",
            "钱",
            "孙",
            "李",
            "王",
            "张",
            "慕容",
            "上官",
            "东方",
            "朱"
        };

    /*
     * 其他中文数组
     */
    private static String[] LAST_NAME_ARR  = {
            "燕",
            "岩",
            "艳",
            "明",
            "建国",
            "小刚",
            "小娟",
            "华",
            "天明",
            "洋",
            "盈盈",
            "仁"
        };

    /*
     * 性别
     */
    private static String[] GENDER_ARR     = {
            "男",
            "女"
        };
    private static DateFormat DATE_FORMATER = new SimpleDateFormat(
            "yyyy年MM月dd日");

    //~ Methods ****************************************************************

    public static Student createStudent(int id) {
        String firstName = getRandomCharFromArray(FIRST_NAME_ARR);
        String lastName  = getRandomCharFromArray(LAST_NAME_ARR);
        String name      = firstName + lastName;

        String gender = GENDER_ARR[new Random().nextInt(1000) % 2];

        String birthday = getRandomDate();

        return new Student(id, name, gender, birthday);
    }


    private static String getRandomCharFromArray(String[] arr) {
        Random random = new Random();
        int    index  = random.nextInt(arr.length);

        return arr[index];
    }

    /**
     * 随机生成一个比当前日期小的日期
     * 
     * @return （yyyy年MM月dd日）
     */
    private static String getRandomDate() {
        Date date     = new Date();
        long dateMill = date.getTime();

        Random random = new Random();
        dateMill = (long) (random.nextDouble() * dateMill);

        return DATE_FORMATER.format(new Date(dateMill));
    }
}
