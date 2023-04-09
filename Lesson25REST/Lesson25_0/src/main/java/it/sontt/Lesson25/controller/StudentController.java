package it.sontt.Lesson25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class StudentController {
    //lấy danh sach hoc vien
    @GetMapping(value = "/hocvien")
    public String getStudentAction(){
        return null;
    }

}
