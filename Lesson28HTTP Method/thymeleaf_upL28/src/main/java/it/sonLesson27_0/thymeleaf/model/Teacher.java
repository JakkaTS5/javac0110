package it.sonLesson27_0.thymeleaf.model;

import lombok.Data;

import java.util.Date;


@Data
public class Teacher {
 private String magv;
 private String hoten;
 private String hocvi;
 private String gioitinh;
 private String hocham;
 private Date ngaysinh;
 private Date ngvl;
 private Double heso;
 private Double mucluong;
 private String makhoa;

    public Teacher(String magv, String hoten, String hocvi, String gioitinh, String hocham, Date ngaysinh, Date ngvl, Double heso, Double mucluong, String makhoa) {
        this.magv = magv;
        this.hoten = hoten;
        this.hocvi = hocvi;
        this.gioitinh = gioitinh;
        this.hocham = hocham;
        this.ngaysinh = ngaysinh;
        this.ngvl = ngvl;
        this.heso = heso;
        this.mucluong = mucluong;
        this.makhoa = makhoa;
    }
}
