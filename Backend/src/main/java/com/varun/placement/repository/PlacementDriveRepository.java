package com.varun.placement.repository;

import com.varun.placement.entity.PlacementDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlacementDriveRepository extends JpaRepository<PlacementDrive, Long> {

    List<PlacementDrive> findByDriveDate(LocalDate driveDate);

    List<PlacementDrive> findByJobRole(String jobRole);

}



