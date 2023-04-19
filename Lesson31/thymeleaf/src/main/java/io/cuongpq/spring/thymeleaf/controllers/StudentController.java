package io.cuongpq.spring.thymeleaf.controllers;

import io.cuongpq.spring.thymeleaf.dto.StudentDto;
import io.cuongpq.spring.thymeleaf.models.Student;
import io.cuongpq.spring.thymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public String indexAction(Model model) {
        List<Student> studentList= studentService.getStudentList();

        model.addAttribute("students", studentList);
        return "students";
    }

    @GetMapping(value = "/student/add")
    public String newStudentAction(Model model) {
        Student student = new Student();

        model.addAttribute("student", student);
        return "student.detail";
    }

    @PostMapping(value = "/student/add", consumes = "application/x-www-form-urlencoded")
    public String addStudentAction(StudentDto studentDto) {
        System.out.println(studentDto);
        Student student = studentService.addStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping(value = "/student/edit/{student_id}")
    public String editStudentAction(
        Model model,
        @PathVariable(value = "student_id") String studentId
    ) {
        Student student = studentService.getStudentById(studentId);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String ngaysinh = formatter.format(student.getNgaysinh());
        StudentDto studentDto = new StudentDto(
                student.getHo(),
                student.getTen(),
                ngaysinh,
                student.getGioitinh(),
                student.getNoisinh(),
                student.getMalop()
        );
        model.addAttribute("student", studentDto);
        model.addAttribute("student_id", studentId);
        model.addAttribute("isMan", studentDto.getGioitinh().equals("Nam"));
        return "student.edit";
    }

    @PostMapping(value = "/student/edit/{student_id}", consumes = "application/x-www-form-urlencoded")
    public String updateStudentAction(
        @PathVariable(value = "student_id") String studentId,
        StudentDto studentDto
    ) {
        boolean update = studentService.updateStudentById(studentId, studentDto);
        return "redirect:/students";
    }

    @GetMapping(value = "/student/delete/{student_id}")
    public String deleteStudentAction(
            @PathVariable(value = "student_id") String studentId
    ) {
        studentService.delStudentById(studentId);


        return "redirect:/students";
    }
}
