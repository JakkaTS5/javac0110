package it.sonlesson25.lesson25_0.model;

import lombok.Data;

import java.sql.Date;
@Data
//chưa cần trong bài này vẫn chạy dc, là entity ảnh xạ sang csdl, ko phải viết lại từng câu query như bên Service
//sau này jpa thi sẽ có entity, annotation column
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


}
