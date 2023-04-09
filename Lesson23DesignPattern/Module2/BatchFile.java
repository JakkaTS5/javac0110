package Module2;

import Module2.handler.FileHandler;
import Module2.handler.StoreHandler;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

public class BatchFile {
    public static void main(String[] args) {
        System.out.println("JAVA DATABASE FIRST");

        //Đọc các giá trị từ file app.config
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("D:\\Java_10.1.2023\\lesson_23\\Module2\\app.config"))  {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Thiết lập tham số kết nối

        String url = properties.getProperty("url");
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");
        String dirPath =  properties.getProperty("dirPath");

        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        System.out.println(dirPath);
        //

        //Step 1: Load driver
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading driver: " + e);
        }

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread readFileHander = new Thread(new FileHandler(dirPath, queue));
        readFileHander.start();

        Thread storeDBHandler = new Thread(new StoreHandler(url, username, password, queue));
        storeDBHandler.start();

    }
}
