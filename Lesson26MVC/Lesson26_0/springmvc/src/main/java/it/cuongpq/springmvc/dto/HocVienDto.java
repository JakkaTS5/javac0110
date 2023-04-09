package it.cuongpq.springmvc.dto;

import lombok.Data;

import java.util.Date;

//Dto = Data transfer object
//POJO
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
    //Getter + Setter
}
