package it.sonLesson27_0.thymeleaf.service;
import it.sonLesson27_0.thymeleaf.dto.StudentDto;
import it.sonLesson27_0.thymeleaf.model.Student;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    DatabaseService databaseService = DatabaseService.getINTANCE();
    Connection connection = databaseService.getConnection();
    public List<Student> getStudentsList() {
        List<Student> output = new ArrayList<>();
        String selectQuery = "SELECT * FROM HOCVIEN";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String mahv = rs.getString("MAHV");
                String ho = rs.getString("HO");
                String ten = rs.getString("TEN");
                Date ngaysinh = rs.getDate("NGSINH");
                String gioitinh = rs.getString("GIOITINH");
                String noisinh = rs.getString("NOISINH");
                String malop = rs.getString("MALOP");

                //in
//                String format = "%-5s %-15s %-10s %-10s %-15s %-15s %-5s";
//                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
                output.add(new Student(mahv,ho,ten,ngaysinh,gioitinh,noisinh,malop));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
    public Student addStudent(StudentDto studentDto){
        DatabaseService databaseService = DatabaseService.getINTANCE();
        connection = databaseService.getConnection();
        UUID uuid = UUID.randomUUID();
        System.out.println("MAHV: " + uuid);
        String mahv = "K" + uuid.toString().substring(0, 4);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date ngaysinh = null;
        try {
            ngaysinh =format.parse(studentDto.getNgaysinh());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //tao doi tuong hoc vien insert vao database
        Student student = new Student(
                mahv,
                studentDto.getHo(),
                studentDto.getTen(),
                ngaysinh,
                studentDto.getGioitinh(),
                studentDto.getNoisinh(),
                studentDto.getMalop()
        );
        // insert query vao database
        String sql = "INSERT INTO HOCVIEN(MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP) VALUE (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getMahv());
            preparedStatement.setString(2, student.getHo());
            preparedStatement.setString(3, student.getTen());
            preparedStatement.setDate(4, new java.sql.Date(student.getNgaysinh().getTime()));//chuyen sang date
            preparedStatement.setString(5, student.getGioitinh());
            preparedStatement.setString(6, student.getNoisinh());
            preparedStatement.setString(7, student.getMalop());
            int iResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }
    public Student getStudentById(String studentId) {
        Student output = null;
        String selectQuery = "SELECT * FROM HOCVIEN WHERE MAHV LIKE ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String mahv = rs.getString("MAHV");
                String ho = rs.getString("HO");
                String ten = rs.getString("TEN");
                java.sql.Date ngaysinh = rs.getDate("NGSINH");
                String gioitinh = rs.getString("GIOITINH");
                String noisinh = rs.getString("NOISINH");
                String malop = rs.getString("MALOP");

                //in
                String format = "%-5s %-15s %-15s %-10s %-15s %-15s %-5s";
                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
                output = new Student(mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
