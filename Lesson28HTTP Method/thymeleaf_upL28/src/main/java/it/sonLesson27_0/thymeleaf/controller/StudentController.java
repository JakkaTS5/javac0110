package it.sonLesson27_0.thymeleaf.controller;

import it.sonLesson27_0.thymeleaf.dto.StudentDto;
import it.sonLesson27_0.thymeleaf.model.Student;
import it.sonLesson27_0.thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public String getStudents(Model model) {
        studentService.getStudentsList();// hien ra trong server
        List<Student> StudentList = studentService.getStudentsList();
        //tao ra "students" để hiển thị bên template
        model.addAttribute("studentsHT", StudentList);

        return "students";// kiem tra xem có file HTML khong
    }

    @GetMapping(value = "/student/add")
    public String newStudent(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentADD", studentDto);
        return "student.detail";
    }

    @PostMapping(value = "/student/add", consumes = "application/x-www-form-urlencoded")
    public String addStudent(StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping(value = "/student/edit/{student_id}")
    public String editStudent(
            @PathVariable("student_id") String studetnId,
            Model model
    ) {
        Student student = studentService.getStudentById(studetnId);
        StudentDto studentDto = new StudentDto(
        );
        model.addAttribute("student",studentDto);
        return "student.edit";
    }
}
