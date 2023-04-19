package io.cuongpq.spring.thymeleaf.controllers;

import io.cuongpq.spring.thymeleaf.dto.StudentDto;
import io.cuongpq.spring.thymeleaf.entity.DepartmentEntity;
import io.cuongpq.spring.thymeleaf.entity.StudentEntity;
import io.cuongpq.spring.thymeleaf.entity.SubjectEntity;
import io.cuongpq.spring.thymeleaf.entity.TeacherEntity;
import io.cuongpq.spring.thymeleaf.models.Student;
import io.cuongpq.spring.thymeleaf.repositorys.DepartmentRepository;
import io.cuongpq.spring.thymeleaf.repositorys.StudentRepository;
import io.cuongpq.spring.thymeleaf.repositorys.SubjectRepository;
import io.cuongpq.spring.thymeleaf.repositorys.TeacherRepository;
import io.cuongpq.spring.thymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ApiStudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping(value = "/students")
    public List<Student> getStudentsAction() {
        return studentService.getStudentList();
    }

    @PostMapping(value = "/student")
    public String addStudentAction(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto);
        Student student = studentService.addStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping(value = "/students2")
    public List<StudentEntity> getStudents2Action() {
        return studentRepository.findByMalop("K13");
    }

    @GetMapping(value = "/students3")
    public List<StudentEntity> getStudents3Action() {
        String sDate1="29/12/2000";
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return studentRepository.findAllByNgsinh(date1);
    }

    @GetMapping(value = "/students4")
    public List<StudentEntity> getStudents4Action() {
        String sDate1="29/12/2000";
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return studentRepository.findAllByNgsinh(date1);
    }

    @GetMapping(value = "/students5")
    public List<StudentEntity> getStudents5Action() {
        String sDate1="29/12/2000";
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return studentRepository.findByHoAndTen("qưeqw", "qưeqwe");
    }

    @GetMapping(value = "/test")
    public Page<TeacherEntity> getTestAction() {
        String sortBy = "gender";
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);

        sort = Sort.by(Sort.Direction.ASC, sortBy);

        PageRequest pageRequest = PageRequest.of(0, 2, sort);


        return teacherRepository.findAll(pageRequest);
    }

    @GetMapping(value = "/test2")
    public List<DepartmentEntity> getTest2Action() {
        String sortBy = "gender";
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);

        sort = Sort.by(Sort.Direction.ASC, sortBy);

        PageRequest pageRequest = PageRequest.of(0, 2, sort);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "07/06/2005";

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        Date date1= null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        return departmentRepository.findByngayThanhlapAfter(date1);
        try {
            return departmentRepository.findByngayThanhlapBetween(date1, new SimpleDateFormat("dd/MM/yyyy").parse("19/12/2005"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(value = "/test3")
    public List<TeacherEntity> getTest3Action() {
        String sortBy = "gender";
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);

        sort = Sort.by(Sort.Direction.ASC, sortBy);

        PageRequest pageRequest = PageRequest.of(0, 2, sort);


        return teacherRepository.findByAllA();
    }


}
