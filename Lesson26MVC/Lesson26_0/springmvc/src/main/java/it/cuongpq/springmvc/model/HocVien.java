package it.cuongpq.springmvc.model;

import lombok.Data;

import java.util.Date;

@Data
public class HocVien {

    private String mahv;


    private String ho;


    private String ten;


    private Date ngaysinh;


    private String gioitinh;


    private String noisinh;


    private String malop;


    public HocVien(String mahv, String ho, String ten, Date ngaysinh, String gioitinh, String noisinh, String malop) {
        this.mahv = mahv;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
    }

    @Override
    public String toString() {
        return "HocVien [mahv=" + mahv + ", ho=" + ho + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", gioitinh="
                + gioitinh + ", noisinh=" + noisinh + ", malop=" + malop + "]";
    }
}
