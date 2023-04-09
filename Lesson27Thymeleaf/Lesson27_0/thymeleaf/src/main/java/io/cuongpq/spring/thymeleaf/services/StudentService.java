package io.cuongpq.spring.thymeleaf.services;

import io.cuongpq.spring.thymeleaf.models.Student;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudentList() {
        DatabaseService databaseService = DatabaseService.getInstance();
        Connection connection = databaseService.getConnection();
        List<Student> output = new ArrayList<>();

        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "SELECT * FROM STUDENT";

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

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
                output.add(new Student(
                    mahv,
                        ho,
                        ten,
                        ngaysinh,
                        gioitinh,
                        noisinh,
                        malop
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;
    }
}
