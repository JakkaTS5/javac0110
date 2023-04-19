package io.cuongpq.spring.thymeleaf.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "department")
@Data
public class DepartmentEntity {
    @Id
    @Column(name = "MAKHOA")
    private String maKhoa;

    @Column(name = "TENKHOA")
    private String tenKhoa;

    @Column(name = "NGTLAP")
    @Temporal(TemporalType.DATE)
    private Date ngayThanhlap;

    @Column(name = "TRGKHOA")
    private String truongKhoa;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<TeacherEntity> teacherEntityList;

    public DepartmentEntity() {
    }

    public DepartmentEntity(String maKhoa, String tenKhoa, Date ngayThanhlap, String truongKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.ngayThanhlap = ngayThanhlap;
        this.truongKhoa = truongKhoa;
    }
}
