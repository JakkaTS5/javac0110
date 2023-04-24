package it.sonLesson27_0.thymeleaf.controller;

import it.sonLesson27_0.thymeleaf.model.Student;
import it.sonLesson27_0.thymeleaf.service.StudentService;
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
        studentService.getStudentsList();// hien ra trong server
        List<Student> StudentList = studentService.getStudentsList();
        //tao ra "students" để hiển thị bên template
        model.addAttribute("students", StudentList);

        return "students";// kiem tra xem có file HTML khong
    }
}
