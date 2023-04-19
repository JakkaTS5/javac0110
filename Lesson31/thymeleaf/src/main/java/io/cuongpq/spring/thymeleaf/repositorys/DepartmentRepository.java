package io.cuongpq.spring.thymeleaf.repositorys;

import io.cuongpq.spring.thymeleaf.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    List<DepartmentEntity> findByngayThanhlapAfter(Date localDate);
    List<DepartmentEntity> findByngayThanhlapBetween(Date startDate, Date endDate);
}
