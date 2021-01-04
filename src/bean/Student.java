package bean;

/**
 * @auther Ashen One
 * @Date 2020/12/30
 */
public class Student {

    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 班级
     */
    private String className;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 手机
     */
    private String mobilePhone;
    /**
     * 手机
     */
    private String email;
    /**
     * 通讯地址
     */
    private String communication;
    /**
     * 邮政编码
     */
    private String postalCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Student() {
    }

    public Student(String name, String sex, String className, String telephone, String mobilePhone, String email, String communication, String postalCode) {
        this.name = name;
        this.sex = sex;
        this.className = className;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.communication = communication;
        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", className='" + className + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", communication='" + communication + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
