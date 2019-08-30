package org.young.ireport.datasource.javabean;

/**
 *
 *
 * @author by Young.ZHU
 *                on 2012-8-3
 *
 * Package&FileName: ds.javabean.Student
 */
public class Student {
    //~ Instance fields ********************************************************

	// 序号
    private int id;
    // 姓名
    private String name;
    // 性别
    private String gender;
    // 出生年月
    private String birthday;
    
    private NativePlace nativePlace;

    //~ Constructors ***********************************************************

    public Student() {
    }


    public Student(int id, String name, String gender, String birthday) {
        this.id           = id;
        this.name         = name;
        this.gender       = gender;
        this.birthday     = birthday;
    }

    //~ Methods ****************************************************************

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getBirthday() {
        return birthday;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


	public NativePlace getNativePlace() {
		return nativePlace;
	}


	public void setNativePlace(NativePlace nativePlace) {
		this.nativePlace = nativePlace;
	}
}
