package io.cuongpq.spring.thymeleaf.controlers;

import io.cuongpq.spring.thymeleaf.models.Student;
import io.cuongpq.spring.thymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public String indexController(Model model) {
        List<Student> studentList = studentService.getStudentList();

        model.addAttribute("students", studentList);
        return "students";
    }
}
