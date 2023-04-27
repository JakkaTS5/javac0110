package it.sonLesson27_0.thymeleaf.controller;


import it.sonLesson27_0.thymeleaf.model.Teacher;
import it.sonLesson27_0.thymeleaf.service.TeacherService;
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
    public String teachersList(Model model) {
//teacherService.getTeacherList();
        List<Teacher> TeachersList = teacherService.getTeacherList();
        model.addAttribute("teachersHT",TeachersList);
        return "teachers";
    }
}
