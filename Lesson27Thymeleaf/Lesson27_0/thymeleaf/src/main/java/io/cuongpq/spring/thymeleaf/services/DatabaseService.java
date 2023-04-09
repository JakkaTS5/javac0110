package io.cuongpq.spring.thymeleaf.services;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseService {
    private static DatabaseService INSTANCE = null;
    private Connection connection;

    private DatabaseService() {}

    public static DatabaseService getInstance() {
        if (INSTANCE != null) return INSTANCE;

        INSTANCE = new DatabaseService();
        INSTANCE.connectDatabase();

        return INSTANCE;
    }

    public void connectDatabase() {
        //Đọc các giá trị từ file app.config
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(".\\app.config")) {
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
            Class.forName("org.postgresql.Driver");
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

    public Connection getConnection() {
        return this.connection;
    }
}
