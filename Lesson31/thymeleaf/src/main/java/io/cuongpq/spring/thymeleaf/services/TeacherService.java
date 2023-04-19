package io.cuongpq.spring.thymeleaf.services;

import io.cuongpq.spring.thymeleaf.models.Teacher;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    public List<Teacher> getTeacherList10() {
        DatabaseService databaseService = DatabaseService.getInstance();
        Connection connection = databaseService.getConnection();
        List<Teacher> output = new ArrayList<>();
        return output;

//        //Định nghĩa chuỗi truy vấn dữ liệu
//            String query = "SELECT * FROM TEACHER ORDER BY MAGV DESC LIMIT 10" ;
//
//        //Tạo đối tượng preparedStatement
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            //In kết quả truy vấn SELECT
//            while (rs.next()) {
//                String magv = rs.getString("MAGV");
//                String hoten = rs.getString("HOTEN");
//                String hocvi = rs.getString("HOCVI");
//                String hocham = rs.getString("HOCHAM");
//                String ngSinh = rs.getString("NGSINH");
//                String ngvl = rs.getString("NGVL");
//
//                //In ra màn hình
//                String format = "%-5s %-15s %-15s %-15s %-15s %-5s";
//                System.out.println(String.format(format, magv, hoten, hocvi,  hocham, ngSinh, ngvl));
//                output.add(new Teacher(
//                        magv,
//                        hoten,
//                        hocvi,
//                        hocham,
//                        ngSinh,
//                        ngvl
//
//
//                ));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return output;
    }

    public List<Teacher> getTeacherList() {
        DatabaseService databaseService = DatabaseService.getInstance();
        Connection connection = databaseService.getConnection();
        List<Teacher> output = new ArrayList<>();

        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "SELECT * FROM TEACHER";

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            //In kết quả truy vấn SELECT
            while (rs.next()) {
                String magv = rs.getString("MAGV");
                String hoten = rs.getString("HOTEN");
                String hocvi = rs.getString("HOCVI");
                String hocham = rs.getString("HOCHAM");
                String ngSinh = rs.getString("NGSINH");
                String ngvl = rs.getString("NGVL");

                //In ra màn hình
                String format = "%-5s %-15s %-15s %-15s %-15s %-5s";
                System.out.println(String.format(format, magv, hoten, hocvi,  hocham, ngSinh, ngvl));
                output.add(new Teacher(
                        magv,
                        hoten,
                        hocvi,
                        hocham,
                        ngSinh,
                        ngvl
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;
    }
}
