package com.varun.placement.controller;

import com.varun.placement.entity.Interview;
import com.varun.placement.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/interviews")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @PostMapping
    public Interview save(@RequestBody Interview interview){
        return service.saveInterview(interview);
    }

    @GetMapping
    public List<Interview> getAll(){
        return service.getAllInterviews();
    }

    @GetMapping("/{id}")
    public Optional<Interview> getById(@PathVariable Long id){
        return service.getInterviewById(id);
    }

    @PutMapping("/{id}")
    public Interview update(@PathVariable Long id,
                            @RequestBody Interview interview){

        return service.updateInterview(id, interview);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteInterview(id);
    }
}