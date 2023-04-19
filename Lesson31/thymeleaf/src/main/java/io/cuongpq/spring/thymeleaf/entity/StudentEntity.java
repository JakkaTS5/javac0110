package io.cuongpq.spring.thymeleaf.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @Column(name = "mahv", length = 6)
    private String mahv;

    @Column(name = "ho", length = 20)
    private String ho;

    @Column(name = "ten", length = 10)
    private String ten;

    @Column(name = "ngsinh")
    private Date ngsinh;

    @Column(name = "gioitinh", length = 3)
    private String gioitinh;

    @Column(name = "noisinh", length = 200)
    private String noisinh;

    @Column(name = "malop", length = 3)
    private String malop;

    @Column(name = "is_delete")
    private Integer is_delete;

    public StudentEntity() {
    }

    public StudentEntity(String mahv, String ho, String ten, Date ngaysinh, String gioitinh, String noisinh, String malop) {
        this.mahv = mahv;
        this.ho = ho;
        this.ten = ten;
        this.ngsinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
    }

    // Constructors, getters and setters, and other methods
}

