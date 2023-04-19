package io.cuongpq.spring.thymeleaf.services;

import io.cuongpq.spring.thymeleaf.dto.StudentDto;
import io.cuongpq.spring.thymeleaf.entity.StudentEntity;
import io.cuongpq.spring.thymeleaf.models.Student;
import io.cuongpq.spring.thymeleaf.repositorys.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentList() {
        List<Student> output = new ArrayList<>();
        List<StudentEntity> result = studentRepository.findAll();
        result.forEach(item -> {
            output.add(new Student(
               item.getMahv(),
               item.getHo(),
               item.getTen(),
               item.getNgsinh(),
               item.getGioitinh(),
               item.getNoisinh(),
               item.getMalop()
            ));
        });

        return output;
//        DatabaseService databaseService =  DatabaseService.getInstance();
//        Connection connection = databaseService.getConnection();
//
//        List<Student> output = new ArrayList<>();
//
//        //Định nghĩa chuỗi truy vấn dữ liệu
//        String query = "SELECT * FROM student;";
//
//        //Tạo đối tượng preparedStatement
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            //In kết quả truy vấn SELECT
//            while (rs.next()) {
//                String mahv = rs.getString("MAHV");
//                String ho = rs.getString("HO");
//                String ten = rs.getString("TEN");
//                Date ngaysinh = rs.getDate("NGSINH");
//                String gioitinh = rs.getString("GIOITINH");
//                String noisinh = rs.getString("NOISINH");
//                String malop = rs.getString("MALOP");
//
//                //In ra màn hình
//                String format = "%-5s %-15s %-15s %-10s %-15s %-15s %-5s";
//                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
//                output.add(new Student(
//                        mahv, ho, ten, new java.util.Date(ngaysinh.getTime()), gioitinh, noisinh, malop));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return output;
    }

    public Student addStudent(StudentDto studentDto) {
//        DatabaseService databaseService = DatabaseService.getInstance();
//        Connection connection = databaseService.getConnection();

        //Sinh mã hoc viên
        UUID uuid = UUID.randomUUID();
        System.out.println("MAHV: " + uuid);
        String mahv = "K" + uuid.toString().substring(0, 4).toUpperCase();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date ngaysinh = null;

        try {
            ngaysinh = format.parse(studentDto.getNgaysinh());
        } catch (ParseException e) {
            ngaysinh = null;
            e.printStackTrace();
        }

        StudentEntity student = new StudentEntity(
                mahv,
                studentDto.getHo(),
                studentDto.getTen(),
                new Date(ngaysinh.getTime()),
                studentDto.getGioitinh(),
                studentDto.getNoisinh(),
                studentDto.getMalop()
        );

        studentRepository.save(student);


//        String sql = "INSERT INTO STUDENT(MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP) VALUES(?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement preparedStatement = null;
//
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, student.getMahv());
//            preparedStatement.setString(2, student.getHo());
//            preparedStatement.setString(3, student.getTen());
//            //util.Date -> sql.Date
//            preparedStatement.setDate(4, new Date(student.getNgaysinh().getTime()));
//            preparedStatement.setString(5, student.getGioitinh());
//            preparedStatement.setString(6, student.getNoisinh());
//            preparedStatement.setString(7, student.getMalop());
//
//            int iResult = preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }

        return null;
    }

    public Student getStudentById(String studentId) {
        DatabaseService databaseService = DatabaseService.getInstance();
        Connection connection = databaseService.getConnection();

        Student output = null;
        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "SELECT * FROM STUDENT WHERE MAHV = ? ";

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentId);

            ResultSet rs = preparedStatement.executeQuery();

            //In kết quả truy vấn SELECT
            while (rs.next()) {
                String mahv = rs.getString("MAHV");
                String ho = rs.getString("HO");
                String ten = rs.getString("TEN");
                Date ngaysinh = rs.getDate("NGSINH");
                String gioitinh = rs.getString("GIOITINH");
                String noisinh = rs.getString("NOISINH");
                String malop = rs.getString("MALOP");

                //In ra màn hình
                String format = "%-5s %-15s %-15s %-10s %-15s %-15s %-5s";
                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
                output = new Student(mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;
    }

    public boolean updateStudentById(String studentId, StudentDto studentDto) {
        DatabaseService databaseService = DatabaseService.getInstance();
        Connection connection = databaseService.getConnection();

        boolean output = false;
        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "UPDATE STUDENT SET HO = ?, TEN = ?, NGSINH = ?, GIOITINH = ?, NOISINH =?, MALOP =? WHERE MAHV = ?";

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date ngaysinh = null;

        try {
            ngaysinh = format.parse(studentDto.getNgaysinh());
        } catch (ParseException e) {
            ngaysinh = null;
            e.printStackTrace();
        }

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentDto.getHo());
            preparedStatement.setString(2, studentDto.getTen());
            preparedStatement.setDate(3, new Date(ngaysinh.getTime()));
            preparedStatement.setString(4, studentDto.getGioitinh());
            preparedStatement.setString(5, studentDto.getNoisinh());
            preparedStatement.setString(6, studentDto.getMalop());
            preparedStatement.setString(7, studentId);

            Integer rs = preparedStatement.executeUpdate();

            output = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;

    }

    public boolean delStudentById(String studentId) {
        DatabaseService databaseService = DatabaseService.getInstance();
        Connection connection = databaseService.getConnection();

        boolean output = false;
        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "DELETE FROM STUDENT WHERE MAHV = ?";


        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentId);

            Integer rs = preparedStatement.executeUpdate();

            output = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;

    }
}
