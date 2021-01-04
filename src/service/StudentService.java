package service;

import bean.Student;

/**
 * @auther Ashen One
 * @Date 2021/1/4
 */
public interface StudentService {
    /**
     * 检查学生是否存在
     *
     * @return boolean  true:学生存在 false:学生不存在
     */
    boolean checkStudentName(String name);

    /**
     * 将user信息保存到数据库
     * true:成功 false:失败
     *
     * @param student
     */
    boolean saveStudent(Student student);

    /**
     * 根据姓名查询学生
     *
     * @param name
     * @return
     */
    Student queryStudentByName(String name);

    /**
     * 根据姓名删除学生
     *
     * @param name
     * @return true:成功 false:失败
     */
    boolean deleteStudentByName(String name);
}
