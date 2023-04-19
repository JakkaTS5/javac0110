package io.cuongpq.spring.thymeleaf.repository;

import io.cuongpq.spring.thymeleaf.entity.StudentEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEnity, String> {

    List<StudentEnity> findBymalop(String malop);

    //Select * from student where ho = ?
    List<StudentEnity> findByHo(String ho);

    List<StudentEnity> findByHoAndTen(String ho, String ten);

    List<StudentEnity> findByhoOrTen(String ho, String ten);

    List<StudentEnity> findByisDeleteIsNotNull();


    @Query("SELECT a FROM StudentEnity a WHERE a.malop = ?1")
    List<StudentEnity> customFindByMaLopHoc(String malop);

    @Query("SELECT a FROM StudentEnity a WHERE a.ten = ?2 AND a.malop = ?1 ")
    List<StudentEnity> customFindByMaLopHocAndTen(String malop, String ten);

    @Query("SELECT a FROM StudentEnity a WHERE a.malop = ?1 AND a.isDelete is null")
    List<StudentEnity> customFindByMaLopHocAndNotDelete(String malop);

    @Query(nativeQuery = true, value = "select * from student where malop= ?1 and is_delete is null")
    List<StudentEnity> customNQFindByMaLopHocAndNotDelete(String malop);

}
