package dao.impl;

import bean.Student;
import dao.BaseDao;
import dao.StudentDao;

/**
 * @auther Ashen One
 * @Date 2020/12/30
 */
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {

    @Override
    public boolean checkStudentName(String username) {
        String sql = "SELECT id FROM students WHERE name = ?";
        Student bean = this.getBean(sql, username);
        return bean != null;
    }

    @Override
    public boolean saveStudent(Student student) {
        String sql = "insert into students(name,sex,className,telephone,mobilePhone,email,communication,postalCode) values(?,?,?,?,?,?,?,?)";
        int update = this.update(sql, student.getName(), student.getSex(), student.getClassName(), student.getTelephone(), student.getMobilePhone(), student.getEmail(), student.getCommunication(), student.getPostalCode());
        return update > 0;
    }

    @Override
    public Student queryStudentByName(String username) {
        String sql = "select name,sex,className,telephone,mobilePhone,email,communication,postalCode FROM students WHERE name =?";
        return this.getBean(sql, username);
    }

    @Override
    public boolean deleteStudentByName(String username) {
        String sql = "delete from students WHERE name =?";
        int update = this.update(sql, username);
        return update > 0;
    }
}
