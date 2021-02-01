package fight.ry.service;

import fight.ry.dao.StudentDao;
import fight.ry.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//service中写一些业务逻辑
//为什么这里是使用StudenDao 而不是FakeStudentDao


@Service
public class StudentService {
    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public List<Student> getAllStudents(){
        return  studentDao.selectAllStudents();
    }
    public  int addStudent(Student student ){
        return studentDao.insertStudent(student);

    }
    public  int upgradeStudent(Student student ){
        return studentDao.upgradeStudent(student);

    }

    public  int deleteStudent(UUID id){
        return studentDao.deleteStudent(id);

    }
}
