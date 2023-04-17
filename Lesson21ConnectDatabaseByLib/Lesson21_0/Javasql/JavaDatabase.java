package Javasql;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class JavaDatabase {
    //use Statement
    public void sqlStatement(Connection connection) {
        //query select
        String selectQuery = "SELECT * FROM HOCVIEN";
        //run
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            //print query
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
            }
            //query insert nen xai insert ignore
            String insertQuery = "INSERT IGNORE INTO HOCVIEN(MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP)" +
                    "VALUES('HV01', 'Tran', 'Thai Son', '1993-11-11', 'Nam', 'Dong Nai', 'P01')";
            int rows = stmt.executeUpdate(insertQuery);
            System.out.println(rows + "changed rows");
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sqlPreparedStatement(Connection connection) {
        String selectQuery = "SELECT * FROM HOCVIEN WHERE HO LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, "Nguyen%");
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
            }

            //query insert nen xai insert ignore
            String insertQuery = "INSERT IGNORE INTO HOCVIEN(MAHV, HO, TEN, NGSINH, GIOITINH, NOISINH, MALOP)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "HV02");
            preparedStatement.setString(2, "Nguyen Ngo");
            preparedStatement.setString(3, "Chieu Thu");
            preparedStatement.setDate(4, java.sql.Date.valueOf("1999-08-05"));
            preparedStatement.setString(5, "Nu");
            preparedStatement.setString(6, "TPHCM");
            preparedStatement.setString(7, "P01");

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + "changed rows");

            //query update
            String updateQuery = "UPDATE HOCVIEN SET HO = ? WHERE MAHV = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "Nguyen");
            preparedStatement.setString(2, "HV01");
            rows = preparedStatement.executeUpdate();
            System.out.println(rows + "changed rows");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
//        System.out.println("java Data First");
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("app.config")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Loading Fail" + e);
        }
//        String url = "jdbc:mariadb://localhost:3306/bai2"
//        String username = "root";
//        String password = "50111993";
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");



        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected!");
            JavaDatabase javaDatabase = new JavaDatabase();
//            chay theo 2 dang ket noi SqlSatement va PreparedStatement
//            javaDatabase.sqlStatement(connection);
//            javaDatabase.sqlPreparedStatement(connection);
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database Connect Fail!");
        }
    }
}
