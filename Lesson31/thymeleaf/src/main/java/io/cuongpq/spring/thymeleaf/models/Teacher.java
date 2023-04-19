package io.cuongpq.spring.thymeleaf.models;

import lombok.Data;

@Data

public class Teacher {
    private String magv;


    private String hoten;

    private String hocvi;


    private String hocham;


    private String ngaysinh;


    private String ngaylam;

    public Teacher(String magv, String hoten, String hocvi, String hocham, String ngaysinh, String ngaylam) {
        this.magv = magv;
        this.hoten = hoten;
        this.hocvi = hocvi;
        this.hocham = hocham;
        this.ngaysinh = ngaysinh;
        this.ngaylam = ngaylam;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "magv='" + magv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", hocvi='" + hocvi + '\'' +
                ", hocham='" + hocham + '\'' +
                ", ngaysinh='" + ngaysinh + '\'' +
                ", ngaylam='" + ngaylam + '\'' +
                '}';
    }
}
