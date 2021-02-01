package fight.ry.dao;

import fight.ry.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//定义操作数据库的方法
public interface StudentDao {
    Optional<Student> selectStudentById(UUID id);
    List<Student> selectAllStudents();
    int insertStudent(Student student);
    int upgradeStudent(Student student);
    int deleteStudent(UUID id);
}
