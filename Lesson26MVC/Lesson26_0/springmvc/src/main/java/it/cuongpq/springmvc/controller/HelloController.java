package it.cuongpq.springmvc.controller;

import it.cuongpq.springmvc.dto.HocVienDto;
import it.cuongpq.springmvc.model.HocVien;
import it.cuongpq.springmvc.service.FileService;
import it.cuongpq.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

//Annonation của Srping boot định nghĩa classs HelloController là 1 Controller
@RestController
@RequestMapping(value = "/api/")
public class HelloController {
    @Autowired
    FileService fileService;

    //GET trong HTTP Method
    @GetMapping(value =  "/hello")
    public String getHelloAction() {
        System.out.println("HelloAction called!");
        return "Hello các bạn trong lớp Java";
    }
    @GetMapping(value =  "/about")
    public String getAboutAction() {
        return "Đây là API about";
    }

    //Trả về danh sách học sinh trong db bai2 phần Database
    //TODO: trả về danh sách student dang json object
    @GetMapping(value =  "/student")
    public List<String> getStudentAction() {
        StudentService studentService = StudentService.getInstance();
        List<String> listStudent = studentService.getStudentList();


        return listStudent;
    }

    //GET với path sử dụng PathParam
    //Example /api/student/K1312/info?ho=Le&ten=Cuong
    @GetMapping(value =  "/student/{student_id}/info")
    public ResponseEntity<HocVien> getStudentByIdAndHoAction(
            @PathVariable(value = "student_id") String studentId,
            @RequestParam(value = "ho", required = false) String ho,
            @RequestParam(value = "ten", required = false) String ten
    ) {
        StudentService studentService = StudentService.getInstance();
        HocVien student = studentService.getStudentById(studentId);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/student")
    public ResponseEntity<HocVien> postStudentAction(@RequestBody HocVienDto hocVienDto) {
        System.out.println(hocVienDto);

        StudentService studentService = StudentService.getInstance();
        HocVien student = studentService.addStudent(hocVienDto);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping(value = "/student/{student_id}")
    public ResponseEntity<HocVien> putStudentByIdAction(
            @PathVariable(value = "student_id") String studentId,
            @RequestBody HocVienDto hocVienDto
    ) {
        //TODO: cập nhật vào cơ sở dữ liệu thông tin của HocVienDto mà client gửi lên
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping(value = "/student/{student_id}")
    public ResponseEntity<HocVien> deleteStudentByIdAction(
            @PathVariable(value = "student_id") String studentId
    ) {
        //TODO: xoa học viên trong db theo student_id
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

//    --------------------------------------------- //

    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.saveFile(file);
        return  new ResponseEntity<>("Upload thanh cong!", HttpStatus.OK);
    }

    @GetMapping(value = "/download/{filename}")
    public ResponseEntity<?> downloadFileAction(
        @PathVariable String filename
    ) {
        Resource file = fileService.download(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
