package com.varun.placement.service;

import com.varun.placement.entity.PlacementDrive;
import com.varun.placement.repository.PlacementDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementDriveService {

    @Autowired
    private PlacementDriveRepository repository;

    public PlacementDrive saveDrive(PlacementDrive drive) {
        return repository.save(drive);
    }

    public List<PlacementDrive> getAllDrives() {
        return repository.findAll();
    }

    public Optional<PlacementDrive> getDriveById(Long id) {
        return repository.findById(id);
    }

    public PlacementDrive updateDrive(Long id, PlacementDrive updatedDrive) {

        PlacementDrive drive = repository.findById(id).orElseThrow();

        drive.setJobRole(updatedDrive.getJobRole());
        drive.setDriveDate(updatedDrive.getDriveDate());
        drive.setLastDateToApply(updatedDrive.getLastDateToApply());
        drive.setVacancies(updatedDrive.getVacancies());
        drive.setCompany(updatedDrive.getCompany());

        return repository.save(drive);
    }

    public void deleteDrive(Long id) {
        repository.deleteById(id);
    }
}