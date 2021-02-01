package fight.ry.dao;

import fight.ry.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
@Resource
public class FakeStudentDao implements StudentDao {
    private static List<Student> database = new ArrayList<>();

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        for(Student s : database){
            if(s.getId().equals(id)){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Student> selectAllStudents() {
        return database;
    }

    @Override
    public int insertStudent(Student student) {
       UUID id = UUID.randomUUID();
       database.add(new Student(id,student.getName()));
       return  1;
    }

    @Override
    public int upgradeStudent(Student student) {
//        先找到这个要更新的student的信息
//        UUID id = student.getId();
//        for (Student s : database){
//            if(s.getId().equals(id)){
//                s = student;
//            }
//            return 1;
//        }
//        return -1;
//        Optional<Student> optionalStudent = selectStudentById(student.getId());
//        if(!optionalStudent.isPresent()){
//            return -1;
//        }
        int indexToUpdate = -1;
        for(int i = 0;i<database.size();i++){
            if(student.getId().equals(database.get(i).getId())){
                indexToUpdate = i;
                break;
            }
        }
        if(indexToUpdate<0) return -1;
        database.set(indexToUpdate,student);
        return 1;
    }

    @Override
    public int deleteStudent(UUID id) {
        Optional<Student> optionalStudent = selectStudentById(id);
        if(!optionalStudent.isPresent()){
            return -1;
        }
        database.remove(optionalStudent.get());
        return 1;
    }

}
