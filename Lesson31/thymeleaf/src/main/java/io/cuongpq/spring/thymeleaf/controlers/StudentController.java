package io.cuongpq.spring.thymeleaf.controlers;

import io.cuongpq.spring.thymeleaf.dto.StudentDto;
import io.cuongpq.spring.thymeleaf.models.Student;
import io.cuongpq.spring.thymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
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

    @GetMapping(value = "/student/add")
    public String newStudentAction(Model model) {
        StudentDto studentDto = new StudentDto();

        model.addAttribute("student", studentDto);

        return "student.detail";
    }

    @PostMapping(value = "/student/add", consumes = "application/x-www-form-urlencoded")
    public String addStudentAction(StudentDto studentDto) {
        studentService.addStudent(studentDto);

        return "redirect:/students";
    }

    @GetMapping(value = "/student/edit/{student_id}")
    public String editStudentAction(
        @PathVariable(value = "student_id") String studentId,
        Model model
    ) {
        Student student = studentService.getStudentById(studentId);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String ngaysinh = format.format(student.getNgaysinh());

        StudentDto studentDto = new StudentDto(
            student.getHo(),
            student.getTen(),
            ngaysinh, //-> 1980-12-23 -> 23/12/1980
            student.getGioitinh(),
            student.getNoisinh(),
            student.getMalop()
        );

        model.addAttribute("student", studentDto);
        model.addAttribute("student_id", studentId);
        model.addAttribute("nam", studentDto.getGioitinh().equals("Nam"));
        return "student.edit";
    }

    @PostMapping(value = "/student/edit/{student_id}", consumes = "application/x-www-form-urlencoded")
    public String updateStudentAction(
            @PathVariable(value = "student_id") String studentId,
            StudentDto studentDto
    ) {
        boolean result = studentService.updateStudentById(studentId, studentDto);

        return "redirect:/students";
    }

    @GetMapping(value = "/student/delete/{student_id}")
    public String deleteStudentAction(
            @PathVariable(value = "student_id") String studentId
    ) {
        boolean result = studentService.deteleStudentById(studentId);

        return "redirect:/students";
    }
}
