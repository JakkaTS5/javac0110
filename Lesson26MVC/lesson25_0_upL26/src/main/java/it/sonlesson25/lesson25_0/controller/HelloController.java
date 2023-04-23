package it.sonlesson25.lesson25_0.controller;

import it.sonlesson25.lesson25_0.dto.HocVienDto;
import it.sonlesson25.lesson25_0.model.HocVien;
import it.sonlesson25.lesson25_0.sevice.FileService;
import it.sonlesson25.lesson25_0.sevice.GiaoVienService;
import it.sonlesson25.lesson25_0.sevice.StudentService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class HelloController {
    @Autowired
    FileService fileService;

    @GetMapping(value = "/hello")
    public String getHelloAction() {
        System.out.println("helloAction");//admin hien
        return "初めまして";
    }

    //return students list in database
    @GetMapping(value = "/students")
    public List<String> getStudentsAction() {
        StudentService studentService = StudentService.getINSTANCE();// new
        List<String> getStudents = studentService.getStudentsList();
        return getStudents;
    }

    @GetMapping(value = "/students/{student_id}")
    // có thể đổi thành list<HocVien>
    public ResponseEntity<HocVien> getStudentsById(
            @PathVariable(value = "student_id") String studentId
    ) {
        StudentService studentService = StudentService.getINSTANCE();// new
        HocVien student = studentService.getStudentById(studentId);
//        System.out.println(studentId);//sever se hien ma studentid
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
    @GetMapping(value = "/giaovien")
    public List<String> getGiaoVienAction() {
        GiaoVienService giaoVienService = GiaoVienService.getINSTANCE();
        List<String> getGiaoViens = giaoVienService.getGiaoViensList();
        return getGiaoViens;
    }

    @GetMapping(value = "/giaovien/{giaovien_id}")
    public String getGiaoVienById(
            @PathVariable(value ="giaovien_id") String giaovienId
    ) {
        GiaoVienService giaoVienService = GiaoVienService.getINSTANCE();
        String giaovien = giaoVienService.getGiaoVienById(giaovienId);
        return giaovien;
    }


    @PostMapping(value = "/students")
    public ResponseEntity<HocVien> postStudentAction(
            @RequestBody HocVienDto hocVienDto) {
        StudentService studentService = StudentService.getINSTANCE();// new
        HocVien student = studentService.addStudent(hocVienDto);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping(value = "/students/{student_id}")
    public ResponseEntity<HocVien> putStudentsById(
            @PathVariable(value = "student_id") String studentId,
            @RequestBody HocVienDto hocVienDto
    ) {
        //todo update info
        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    @DeleteMapping(value = "/students/{student_id}")
    public ResponseEntity<HocVien> deleteStudentsById(
            @PathVariable(value = "student_id") String studentId
    ) {
        //todo xoa info
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //----------------------------------------------//
//upload
    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file) {
        fileService.saveFile(file);
        return new ResponseEntity<>("uploaded !", HttpStatus.OK);
    }

    @GetMapping(value = "/download/{fileName}")
    public ResponseEntity<?> downloadFile(
            @PathVariable String fileName
    ) {
        Resource file = fileService.downloadFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName =\"" + file.getFilename() + "\"").body(file);
    }
}

