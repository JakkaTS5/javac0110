package it.cuongpq.springmvc.service;

import it.cuongpq.springmvc.dto.HocVienDto;
import it.cuongpq.springmvc.model.HocVien;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class StudentService {
    private static StudentService INSTANCE = null;
    private Connection connection;

    private StudentService() {
    }

    public static StudentService getInstance() {
        if (INSTANCE != null) return INSTANCE;

        INSTANCE = new StudentService();
        INSTANCE.connectDatabase();

        return INSTANCE;
    }

    public void connectDatabase() {
        //Đọc các giá trị từ file app.config
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("D:\\Java_10.1.2023\\lesson_25\\springmvc\\src\\main\\resources\\app.config")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Thiết lập tham số kết nối
        //Step 2: Định nghĩa url kết nối
        String url = properties.getProperty("url");

        //Step 3: Tạo kết nối
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");

        //Step 1: Load driver
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading driver: " + e);
        }

        //Tạo đối tượng connection
        try {
            this.connection = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Database connect fail!");
        }
    }

    public List<String> getStudentList() {
        List<String> output = new ArrayList<>();

        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "SELECT * FROM HOCVIEN WHERE HO LIKE ? ";

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, "Nguyen%");

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
                output.add(String.format(format, mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;
    }

    public HocVien getStudentById(String studentId) {
        HocVien output = null;
        //Định nghĩa chuỗi truy vấn dữ liệu
        String query = "SELECT * FROM HOCVIEN WHERE MAHV = ? ";

        //Tạo đối tượng preparedStatement
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
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
                output = new HocVien(mahv, ho, ten, ngaysinh, gioitinh, noisinh, malop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return output;
    }

    public HocVien addStudent(HocVienDto hocVienDto) {
        //Sinh mã hoc viên
        UUID uuid = UUID.randomUUID();
        System.out.println("MAHV: " + uuid);
        String mahv = "K" + uuid.toString().substring(0, 9);

        HocVien hocVien = new HocVien(
            mahv,
            hocVienDto.getHo(),
            hocVienDto.getTen(),
            hocVienDto.getNgaysinh(),
            hocVienDto.getGioitinh(),
            hocVienDto.getNoisinh(),
            hocVienDto.getMalop()
        );

        String sql = "INSERT INTO HOCVIEN(MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, hocVien.getMahv());
            preparedStatement.setString(2, hocVien.getHo());
            preparedStatement.setString(3, hocVien.getTen());
            //util.Date -> sql.Date
            preparedStatement.setDate(4, new Date(hocVien.getNgaysinh().getTime()));
            preparedStatement.setString(5, hocVien.getGioitinh());
            preparedStatement.setString(6, hocVien.getNoisinh());
            preparedStatement.setString(7, hocVien.getMalop());

            int iResult = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return hocVien;
    }
}
