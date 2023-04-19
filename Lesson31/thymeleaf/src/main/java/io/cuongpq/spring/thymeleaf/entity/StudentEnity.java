package io.cuongpq.spring.thymeleaf.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//Định nghĩa lớp này là 1 ánh xạ của 1 bảng trong cơ sở dữ liệu
@Entity
//Định nghĩa tên bảng trong cơ sở dữ liệu muốn ánh xạ
@Table(name = "student")
//Auto getter/setter
@Data
public class StudentEnity {

    //Định nghĩa đây là field primary key
    @Id
    //Định nghĩa tên cột trong cở sở liệu
    @Column(name = "mahv", length = 6)
    private String mahv;

    @Column(name = "ho", length = 20)
    private String ho;

    @Column(name = "ten", length = 10)
    private String ten;

    @Column(name = "ngsinh")
    private Date ngaysinh;

    @Column(name = "gioitinh", length = 3)
    private String gioitinh;

    @Column(name = "noisinh", length = 200)
    private String noisinh;

    @Column(name = "malop", length = 3)
    private String malop;

    @Column(name = "is_delete")
    private Integer isDelete;

    //Không ánh xạ trong cơ sở dữ liệu khi sử dụng Transient
    @Transient
    private Integer age;

    public StudentEnity() {
    }

    public StudentEnity(String mahv, String ho, String ten, Date ngaysinh, String gioitinh, String noisinh, String malop, Integer isDelete) {
        this.mahv = mahv;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "StudentEnity{" +
                "mahv='" + mahv + '\'' +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", gioitinh='" + gioitinh + '\'' +
                ", noisinh='" + noisinh + '\'' +
                ", malop='" + malop + '\'' +
                '}';
    }
}
