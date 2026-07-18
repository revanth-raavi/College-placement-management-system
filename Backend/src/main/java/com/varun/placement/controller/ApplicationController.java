package com.varun.placement.controller;

import com.varun.placement.dto.ApplicationRequest;
import com.varun.placement.entity.Application;
import com.varun.placement.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @PostMapping
    public Application save(@RequestBody ApplicationRequest request){

        return service.saveApplication(request);

    }

    @GetMapping
    public List<Application> getAll(){

        return service.getAllApplications();

    }

    @GetMapping("/{id}")
    public Optional<Application> getById(@PathVariable Long id){

        return service.getApplicationById(id);

    }

    @PutMapping("/{id}")
    public Application update(@PathVariable Long id,
                              @RequestBody ApplicationRequest request){

        return service.updateApplication(id, request);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        service.deleteApplication(id);

    }

}