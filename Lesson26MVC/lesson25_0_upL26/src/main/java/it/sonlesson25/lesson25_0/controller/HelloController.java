package it.sonlesson25.lesson25_0.controller;

import it.sonlesson25.lesson25_0.model.HocVien;
import it.sonlesson25.lesson25_0.sevice.GiaoVienService;
import it.sonlesson25.lesson25_0.sevice.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/")
public class HelloController {
    @GetMapping(value="/hello")
    public String getHelloAction(){
        System.out.println("helloAction");//admin hien
        return "初めまして";
    }
    //return students list in database
    @GetMapping(value="/students")
    public List<String> getStudentsAction(){
        StudentService studentService = StudentService.getINSTANCE();// new
        List<String> getStudents = studentService.getStudentsList();
        return getStudents;
    }
    @GetMapping(value = "/students/{student_id}")
    // có thể đổi thành list<HocVien>
    public ResponseEntity<HocVien> getStudentsById(
            @PathVariable(value = "student_id")String studentId
    ) {
        StudentService studentService = StudentService.getINSTANCE();// new
        HocVien student = studentService.getStudentById(studentId);
        System.out.println(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
//    @GetMapping(value = "/students/{student_id}")
//    public List<String> getStudentsByIdAndHo(
//            @PathVariable(value = "student_id")String studentId,
//            @RequestParam(value = "ho", required = false) String ho
//    ) {
////        StudentService studentService = StudentService.getINSTANCE(); test thử API nên xóa doạn này
////        List<String> getStudents = studentService.getStudentsList(); phần này để kết nối csdl lấy bên Service
//        System.out.println(studentId);
//        System.out.println(ho);
//        return null;
//    }
    @GetMapping(value="/giaovien")
    public List<String> getGiaoVienAction(){
        GiaoVienService giaoVienService = GiaoVienService.getINSTANCE();
        List<String>getGiaoViens =giaoVienService.getGiaoViensList();
        return getGiaoViens;
    }
    @GetMapping(value="/giaovien/{giaovien_id}")
    public String getGiaoVienById(
            @PathVariable(value = "giaovien_id")String giaoVienId
    ){
        GiaoVienService giaoVienService = GiaoVienService.getINSTANCE();
        String giaovien = giaoVienService.getGiaoVienById(giaoVienId);
        return giaovien;
    }
}
