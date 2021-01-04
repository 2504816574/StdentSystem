package dao;

import bean.Student;

/**
 * @auther Ashen One
 * @Date 2020/12/30
 */
public interface StudentDao {
    /**
     * 检查学生是否存在
     * sql: select id from students where username = ?
     *
     * @return boolean  true:学生存在 false:学生不存在
     */
    boolean checkStudentName(String username);

    /**
     * 将user信息保存到数据库
     * sql:insert into students(name,sex,className,telephone,mobilePhone,email,communication,postalCode) values(?,?,?,?,?,?,?,?)
     *
     * @param student
     */
    boolean saveStudent(Student student);

    /**
     * 根据姓名查询学生
     * select name,sex,className,telephone,mobilePhone,email,communication,postalCode FROM students WHERE name =?
     *
     * @param username
     * @return
     */
    Student queryStudentByName(String username);

    /**
     * delete from students WHERE name =?
     *
     * @param username
     * @return
     */
    boolean deleteStudentByName(String username);

}
