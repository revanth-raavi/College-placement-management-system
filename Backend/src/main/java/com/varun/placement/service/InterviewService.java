package com.varun.placement.service;

import com.varun.placement.entity.Interview;
import com.varun.placement.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository repository;

    public Interview saveInterview(Interview interview){
        return repository.save(interview);
    }

    public List<Interview> getAllInterviews(){
        return repository.findAll();
    }

    public Optional<Interview> getInterviewById(Long id){
        return repository.findById(id);
    }

    public Interview updateInterview(Long id, Interview updated){

        Interview interview = repository.findById(id).orElseThrow();

        interview.setApplication(updated.getApplication());
        interview.setRound(updated.getRound());
        interview.setInterviewDate(updated.getInterviewDate());
        interview.setInterviewTime(updated.getInterviewTime());
        interview.setRemarks(updated.getRemarks());

        return repository.save(interview);
    }

    public void deleteInterview(Long id){
        repository.deleteById(id);
    }
}