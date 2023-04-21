package it.sonlesson25.lesson25_0.dto;

import lombok.Data;

import java.sql.Date;
@Data
public class HocVienDto {
    private String ho;
    private String ten;
    private Date ngaysinh;
    private String gioitinh;
    private String noisinh;
    private String malop;

    public HocVienDto(String ho, String ten, Date ngaysinh, String gioitinh, String noisinh, String malop) {
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
    }
}
