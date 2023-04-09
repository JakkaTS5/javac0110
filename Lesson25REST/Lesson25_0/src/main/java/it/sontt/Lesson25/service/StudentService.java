package it.sontt.Lesson25.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class StudentService {
    private Connection connection;
    private static StudentService INSTANCE = null;

    private StudentService() {

    }

    public static StudentService getInstance() {
        if (INSTANCE != null) return INSTANCE;
        INSTANCE = new StudentService();
        INSTANCE.connectDatabase();
        return null;
    }

    public void connectDatabase() {
 //Đọc các giá trị từ file app.config
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("app.config"))  {
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
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected!");




        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Database connect fail!");
        }
    }
}
