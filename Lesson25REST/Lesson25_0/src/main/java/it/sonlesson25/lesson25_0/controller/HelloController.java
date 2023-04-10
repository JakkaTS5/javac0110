package it.sonlesson25.lesson25_0.controller;

import it.sonlesson25.lesson25_0.sevice.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/")
public class HelloController {
    @GetMapping(value="/hello")
    public String getHelloAction(){
        System.out.println("helloAction");
        return "初めまして";
    }
    //return students list in database
    @GetMapping(value="/students")
    public List<String> getStudentsAction(){
        StudentService studentService = StudentService.getINSTANCE();// new
        List<String> getStudents = studentService.getStudentsList();
        return getStudents;
    }
}
