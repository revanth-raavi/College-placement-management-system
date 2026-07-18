package com.varun.placement.service;

import com.varun.placement.entity.Offer;
import com.varun.placement.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository repository;

    public Offer saveOffer(Offer offer){
        return repository.save(offer);
    }

    public List<Offer> getAllOffers(){
        return repository.findAll();
    }

    public Optional<Offer> getOfferById(Long id){
        return repository.findById(id);
    }

    public Offer updateOffer(Long id, Offer updated){

        Offer offer = repository.findById(id).orElseThrow();

        offer.setStudent(updated.getStudent());
        offer.setCompany(updated.getCompany());
        offer.setSalary(updated.getSalary());
        offer.setJoiningDate(updated.getJoiningDate());
        offer.setStatus(updated.getStatus());

        return repository.save(offer);
    }

    public void deleteOffer(Long id){
        repository.deleteById(id);
    }

}