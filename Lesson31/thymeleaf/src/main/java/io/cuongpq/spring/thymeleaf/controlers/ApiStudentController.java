package io.cuongpq.spring.thymeleaf.controlers;

import io.cuongpq.spring.thymeleaf.dto.StudentDto;
import io.cuongpq.spring.thymeleaf.entity.StudentEnity;
import io.cuongpq.spring.thymeleaf.models.Student;
import io.cuongpq.spring.thymeleaf.repository.StudentRepository;
import io.cuongpq.spring.thymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ApiStudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/students")
    public List<Student> getStudentsAction() {
        return studentService.getStudentList();
    }


    @GetMapping(value = "/test")
    public List<StudentEnity> getTestAction() {
//        return studentRepository.findByhoOrTen("Nguyen Van", "Long");
        return studentRepository.customFindByMaLopHocAndTen("K11", "Han");
    }

    @PostMapping(value = "/student")
    public String addStudentAction(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto);

        studentService.addStudent(studentDto);

        return "";
    }

    @PutMapping(value = "/student/{student_id}")
    public String updateStudentAction(
            @PathVariable(value = "student_id") String studentId,
            @RequestBody StudentDto studentDto) {

        System.out.println(studentId);
        System.out.println(studentDto);

        studentService.updateStudentById(studentId, studentDto);

        return "";
    }

}
