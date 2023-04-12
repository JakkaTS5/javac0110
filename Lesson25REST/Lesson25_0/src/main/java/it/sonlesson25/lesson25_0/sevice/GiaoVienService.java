package it.sonlesson25.lesson25_0.sevice;

import it.sonlesson25.lesson25_0.model.HocVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GiaoVienService {
    private static GiaoVienService INSTANCE = null;
    private Connection connection;
    private GiaoVienService(){
    }
    public static GiaoVienService getINSTANCE() {
        if (INSTANCE != null) return INSTANCE;
        INSTANCE = new GiaoVienService();
        INSTANCE.connectionDatabase();
        return INSTANCE;
    }

    public void connectionDatabase() {
        String url = "jdbc:mariadb://localhost:3306/bai2";
        String username = "root";
        String password = "50111993";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected!!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Loading Driver!");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database Connect Failed!!");
        }
    }
    public List<String> getGiaoViensList() {
        List<String> output = new ArrayList<>();
        String selectQuery = "SELECT * FROM giaovien";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectQuery);
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
                Integer isdelete = rs.getInt("is_delete");

                //in
                String format = "%-5s %-20s %-5s %-3s %-5s %-15s %-15s %-5s %-15s %-5s";
                System.out.println(String.format(format, magv, hoten, hocvi, gioitinh, hocham, ngaysinh, ngvl,heso,mucluong,makhoa));
                output.add(String.format(format, magv, hoten, hocvi, gioitinh, hocham, ngaysinh, ngvl,heso,mucluong,makhoa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return output;
    }
    public String getGiaoVienById(String giaoVienId){
        String output = "";
        String selectQuery = "SELECT * FROM GIAOVIEN WHERE MAGV LIKE ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, giaoVienId);
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
                Integer isdelete = rs.getInt("is_delete");

                //in
                String format = "%-5s %-20s %-5s %-3s %-5s %-15s %-15s %-5s %-15s %-5s";
                System.out.println(String.format(format, magv, hoten, hocvi, gioitinh, hocham, ngaysinh, ngvl,heso,mucluong,makhoa));
                output = String.format(format, magv, hoten, hocvi, gioitinh, hocham, ngaysinh, ngvl,heso,mucluong,makhoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
