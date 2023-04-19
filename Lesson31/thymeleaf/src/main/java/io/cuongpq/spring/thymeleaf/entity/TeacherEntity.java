package io.cuongpq.spring.thymeleaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "teacher")
@Data
public class TeacherEntity {
    @Id
    @Column(name = "MAGV")
    private String id;

    @Column(name = "HOTEN")
    private String name;

    @Column(name = "HOCVI")
    private String degree;

    @Column(name = "HOCHAM")
    private String rank;

    @Column(name = "GIOITINH")
    private String gender;

    @Column(name = "NGSINH")
    private LocalDate dateOfBirth;

    @Column(name = "NGVL")
    private LocalDate dateOfJoining;

    @Column(name = "HESO")
    private Float coefficient;

    @Column(name = "MUCLUONG")
    private String salary;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "MAKHOA")
    @JsonBackReference
    private DepartmentEntity department;

    @Transient
    private String test = "aa";
}
