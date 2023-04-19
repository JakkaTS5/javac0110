package io.cuongpq.spring.thymeleaf.controllers;

import io.cuongpq.spring.thymeleaf.entity.DepartmentEntity;
import io.cuongpq.spring.thymeleaf.entity.StudentEntity;
import io.cuongpq.spring.thymeleaf.entity.SubjectEntity;
import io.cuongpq.spring.thymeleaf.entity.TeacherEntity;
import io.cuongpq.spring.thymeleaf.repositorys.DepartmentRepository;
import io.cuongpq.spring.thymeleaf.repositorys.StudentRepository;
import io.cuongpq.spring.thymeleaf.repositorys.SubjectRepository;
import io.cuongpq.spring.thymeleaf.repositorys.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ApiTestController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;


    @GetMapping(value = "/test/student")
    public List<StudentEntity> getTestStudentAction() {
        //?

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sDate = "01/03/1986";
        LocalDate date = LocalDate.parse(sDate, formatter);

        Date newDate = null;
        try {
             newDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<StudentEntity> output = studentRepository.findByNgsinhAfter(newDate);
        return output;
    }

    @GetMapping(value = "/test/student2")
    public List<StudentEntity> getTestStudent2Action() {
        //?

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sDate = "01/03/1986";
        LocalDate date = LocalDate.parse(sDate, formatter);

        Date newDate = null;
        Date endDate = null;
        try {
            newDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            endDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<StudentEntity> output = studentRepository.findByNgsinhBetween(newDate, endDate);
        output = studentRepository.findByHoContaining("N");
        output = studentRepository.findByAllSort();
        return output;
    }

    @GetMapping(value = "/test/teacher")
    public List<TeacherEntity> getTestTeacherAction() {

        List<TeacherEntity> output = teacherRepository.findAll();
        return output;
    }

    @GetMapping(value = "/test/department")
    public List<DepartmentEntity> getTestDepartmentAction() {

        List<DepartmentEntity> output = departmentRepository.findAll();
        return output;
    }

    @GetMapping(value = "/test/subject")
    public List<SubjectEntity> getTestSubjectAction() {

        List<SubjectEntity> output = subjectRepository.findAll();
        return output;
    }

    @GetMapping(value = "/test/student5")
    public Page<StudentEntity> getTestStudent5Action(
    ) {
        String sortBy = "mahv";
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);

        //Trong thuc te khi nhan du lieu tu client
        Integer pageNum = 0;
        PageRequest pageRequest = PageRequest.of(pageNum, 2, sort);

        Page<StudentEntity> output = studentRepository.findAll(pageRequest);
        return output;
    }

    @GetMapping(value = "/test/student4")
    public Page<StudentEntity> getTestStudent4Action(
            @RequestParam(name = "page") Integer pageNum,
            @RequestParam(name = "size") Integer pageSize
    ) {
        String sortBy = "mahv";
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);

        //Trong thuc te khi nhan du lieu tu client
        pageNum = pageNum - 1;
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, sort);

        Page<StudentEntity> output = studentRepository.findAll(pageRequest);
        return output;
    }
}
