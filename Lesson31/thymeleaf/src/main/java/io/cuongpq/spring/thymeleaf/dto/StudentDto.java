package io.cuongpq.spring.thymeleaf.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    private String ho;


    private String ten;


    private String ngaysinh;


    private String gioitinh;


    private String noisinh;


    private String malop;

    public StudentDto(String ho, String ten, String ngaysinh, String gioitinh, String noisinh, String malop) {
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", gioitinh='" + gioitinh + '\'' +
                ", noisinh='" + noisinh + '\'' +
                ", malop='" + malop + '\'' +
                '}';
    }
}
