package io.cuongpq.spring.thymeleaf.repositorys;

import io.cuongpq.spring.thymeleaf.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
