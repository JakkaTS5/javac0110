package io.cuongpq.spring.thymeleaf.repositorys;

import io.cuongpq.spring.thymeleaf.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

    @Query("SELECT a FROM TeacherEntity a JOIN FETCH a.department")
    List<TeacherEntity> findByAllA();
}
