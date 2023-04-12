package it.sonlesson25.lesson25_0.sevice;

import it.sonlesson25.lesson25_0.model.HocVien;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class StudentService {
    private static StudentService INSTANCE = null;
    private Connection connection;

    private StudentService() {

    }

    public static StudentService getINSTANCE() {
        if (INSTANCE != null) return INSTANCE;
        INSTANCE = new StudentService();
        INSTANCE.connectionDatabase();
        return INSTANCE;
    }

    public void connectionDatabase() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Loading Driver!");
        }
        String url = "jdbc:mariadb://localhost:3306/bai2";
        String username = "root";
        String password = "50111993";
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database Connect Failed!!");
        }
    }

    public List<String> getStudentsList() {
        List<String> output = new ArrayList<>();
        String selectQuery = "SELECT * FROM HOCVIEN";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectQuery);
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
                output.add(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return output;
    }
    public List<HocVien> getStudentById(String studentId){
        List<HocVien> output = new ArrayList<>();
        String selectQuery = "SELECT * FROM HOCVIEN WHERE MAHV LIKE ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, studentId);
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
                output.add(new HocVien(mahv,ho,ten, ngaysinh,gioitinh,noisinh,malop));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

}


