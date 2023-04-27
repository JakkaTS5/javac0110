package it.sonLesson27_0.thymeleaf.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//lam nv ket noi csdl
public class DatabaseService {
    private static DatabaseService INSTANCE = null;
    private Connection connection;

    private DatabaseService() {

    }

    public static DatabaseService getINTANCE() {
        if (INSTANCE != null) return INSTANCE;
        INSTANCE = new DatabaseService();
        INSTANCE.connectionDatabase();
        return INSTANCE;
    }

    public void connectionDatabase() {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("H:\\Java\\JavaC0110\\Lesson27Thymeleaf,Bootstrap\\thymeleaf\\src\\main\\resources\\app.config");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Loading Server");
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Database Connect Failed!!");
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
}

