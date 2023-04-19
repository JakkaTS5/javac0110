package io.cuongpq.spring.thymeleaf.repositorys;

import io.cuongpq.spring.thymeleaf.entity.StudentEntity;
import io.cuongpq.spring.thymeleaf.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

//    @Query("SELECT s FROM Student s WHERE s.malop = ?1")
    List<StudentEntity> findByMalop(String malop);

    @Query("SELECT s FROM StudentEntity s WHERE s.ho = ?1 AND s.ten = ?2")
    List<StudentEntity> findByHoAndTen(String ho, String ten);

    List<StudentEntity> findAll();
//    List<StudentEntity> findAllById(String id);
    List<StudentEntity> findAllByNgsinh(Date date);

    List<StudentEntity> findByNgsinhAfter(Date date);

    List<StudentEntity> findByNgsinhBetween(Date sDate, Date eDate);

    List<StudentEntity> findByHoContaining(String ho);

    @Query("SELECT s FROM StudentEntity s ORDER BY s.mahv DESC")
    List<StudentEntity> findByAllSort();
}
