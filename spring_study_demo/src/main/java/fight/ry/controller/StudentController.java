package fight.ry.controller;

import fight.ry.model.Student;
import fight.ry.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by zsl on 2017/9/2.
 */

@RestController
@RequestMapping("/springboot")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return  studentService.getAllStudents();
    }
    @PostMapping
    public String addStudent(@RequestBody Student student){
      studentService.addStudent(student);
      return  "Added student";
        }
    @PutMapping
    public String upgradeStudent(@RequestBody Student student){
        studentService.upgradeStudent(student);
        return "Upgrade student";
    }
    @DeleteMapping(path = "{id}")
//    localhost:8080/springboot/123
    public String deleteStudent(@PathVariable("id") UUID id){
        studentService.deleteStudent(id);
        return "Deleted student";
    }
}
