package com.varun.placement.repository;

import com.varun.placement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByBranch(String branch);

    List<Student> findByCgpaGreaterThanEqual(Double cgpa);

}