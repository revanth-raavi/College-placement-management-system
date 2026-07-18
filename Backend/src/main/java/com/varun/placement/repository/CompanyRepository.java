package com.varun.placement.repository;

import com.varun.placement.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByLocation(String location);

    List<Company> findByEligibleCgpaLessThanEqual(Double cgpa);

}