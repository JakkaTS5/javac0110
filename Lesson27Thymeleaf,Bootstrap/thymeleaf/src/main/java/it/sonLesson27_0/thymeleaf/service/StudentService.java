package it.sonLesson27_0.thymeleaf.service;
import it.sonLesson27_0.thymeleaf.model.Student;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                String format = "%-5s %-15s %-15s %-10s %-15s %-15s %-5s";
                System.out.println(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
                output.add(new Student(mahv,ho,ten,ngaysinh,gioitinh,noisinh,malop));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
