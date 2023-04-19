package io.cuongpq.spring.thymeleaf.controlers;

import io.cuongpq.spring.thymeleaf.services.StudentService;
import io.cuongpq.spring.thymeleaf.services.TeacherService;
import io.cuongpq.spring.thymeleaf.models.Student;
import io.cuongpq.spring.thymeleaf.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "/teachers")
    public String indexController(Model model) {
        List<Teacher> teacherList = teacherService.getTeacherList();

        model.addAttribute("teachers", teacherList);
        return "teachers";
    }
}
