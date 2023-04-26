package it.sonLesson27_0.thymeleaf.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String mahv ="";
    private String ho ="";
    private String ten ="";
    private String ngaysinh ="";
    private String gioitinh ="";
    private String noisinh ="";
    private String malop ="";

    public StudentDto(){

    }
    public StudentDto(String mahv, String ho, String ten, String ngaysinh, String gioitinh, String noisinh, String malop) {
        this.mahv = mahv;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
    }


}
