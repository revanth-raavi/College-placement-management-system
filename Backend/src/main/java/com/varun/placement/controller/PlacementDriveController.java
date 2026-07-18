package com.varun.placement.controller;

import com.varun.placement.entity.PlacementDrive;
import com.varun.placement.service.PlacementDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/drives")
public class PlacementDriveController {

    @Autowired
    private PlacementDriveService service;

    @PostMapping
    public PlacementDrive save(@RequestBody PlacementDrive drive) {
        return service.saveDrive(drive);
    }

    @GetMapping
    public List<PlacementDrive> getAll() {
        return service.getAllDrives();
    }

    @GetMapping("/{id}")
    public Optional<PlacementDrive> getById(@PathVariable Long id) {
        return service.getDriveById(id);
    }

    @PutMapping("/{id}")
    public PlacementDrive update(@PathVariable Long id,
                                 @RequestBody PlacementDrive drive) {

        return service.updateDrive(id, drive);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDrive(id);
    }
}