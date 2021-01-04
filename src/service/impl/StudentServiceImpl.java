package service.impl;

import bean.Student;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import service.StudentService;

/**
 * @author 25048
 * @Date 2021/1/4
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean checkStudentName(String name) {
        return studentDao.checkStudentName(name);
    }

    @Override
    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public Student queryStudentByName(String name) {
        return studentDao.queryStudentByName(name);
    }

    @Override
    public boolean deleteStudentByName(String name) {
        return studentDao.deleteStudentByName(name);
    }
}
