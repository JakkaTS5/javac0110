package io.cuongpq.spring.thymeleaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subject")
@Data
public class SubjectEntity {
    @Id
    @Column(name = "MAMH")
    private String maMH;

    @Column(name = "TENMH")
    private String tenMH;

    @Column(name = "TCLT")
    private int tcLT;

    @Column(name = "TCTH")
    private int tcTH;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "MAKHOA")
    private DepartmentEntity department;
}
