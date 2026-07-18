package com.varun.placement.service;

import com.varun.placement.dto.ApplicationRequest;
import com.varun.placement.entity.Application;
import com.varun.placement.entity.PlacementDrive;
import com.varun.placement.entity.Student;
import com.varun.placement.repository.ApplicationRepository;
import com.varun.placement.repository.PlacementDriveRepository;
import com.varun.placement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PlacementDriveRepository placementDriveRepository;

    public Application saveApplication(ApplicationRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        PlacementDrive drive = placementDriveRepository.findById(request.getDriveId())
                .orElseThrow(() -> new RuntimeException("Drive not found"));

        Application application = new Application();

        application.setStudent(student);
        application.setPlacementDrive(drive);
        application.setStatus(request.getStatus());

        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    public Application updateApplication(Long id, ApplicationRequest request) {

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        PlacementDrive drive = placementDriveRepository.findById(request.getDriveId())
                .orElseThrow(() -> new RuntimeException("Drive not found"));

        application.setStudent(student);
        application.setPlacementDrive(drive);
        application.setStatus(request.getStatus());

        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}