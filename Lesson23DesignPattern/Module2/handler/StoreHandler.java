package Module2.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;

public class StoreHandler implements Runnable {
    String url;
    String username;
    String password;
    LinkedBlockingQueue<String> queue;

    Connection conn;
    boolean isConnected = false;

    public StoreHandler(String url, String username, String password, LinkedBlockingQueue<String> queue) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.queue = queue;
    }

    void connectDatabase() {
        while (!isConnected) {
            try {
                conn = DriverManager.getConnection(url, username, password);
                isConnected = true;
                System.out.println("Database connected");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            connectDatabase();
            while (isConnected) {
                try {
                    String line = queue.take();
                    if (line != null) {
                        String sql = "INSERT INTO batchfile(data) values (?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, line);
                        preparedStatement.executeUpdate();

                    }
                } catch (SQLException | InterruptedException e) {
                    isConnected = false;
                    e.printStackTrace();
                }

            }
        }
    }
}
