package it.sonLesson27_0.thymeleaf.service;

import it.sonLesson27_0.thymeleaf.model.Teacher;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class TeacherService {
    DatabaseService databaseService = DatabaseService.getINTANCE();
    Connection connection = databaseService.getConnection();

    public List<Teacher> getTeacherList() {
        List<Teacher> output = new ArrayList<>();
        String selectQuery = "SELECT * FROM GIAOVIEN";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String magv = rs.getString("MAGV");
                String hoten = rs.getString("HOTEN");
                String hocvi = rs.getString("HOCVI");
                String gioitinh = rs.getString("GIOITINH");
                String hocham = rs.getString("HOCHAM");
                Date ngaysinh = rs.getDate("NGSINH");
                Date ngvl = rs.getDate("NGVL");
                Double heso = rs.getDouble("HESO");
                Double mucluong = rs.getDouble("MUCLUONG");
                String makhoa = rs.getString("MAKHOA");
                String format = "%-5s %-20s %-5s %-4s %-5s %-10s %-10s %-5s %-10s %-5s";
            System.out.println(String.format(format,magv,hoten,hocvi,gioitinh,hocham,ngaysinh,ngvl,heso,mucluong,makhoa));
                output.add(new Teacher(magv,hoten,hocvi,gioitinh,hocham,ngaysinh,ngvl,heso,mucluong,makhoa));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
