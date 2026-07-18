package com.varun.placement.controller;

import com.varun.placement.entity.Offer;
import com.varun.placement.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService service;

    @PostMapping
    public Offer save(@RequestBody Offer offer){
        return service.saveOffer(offer);
    }

    @GetMapping
    public List<Offer> getAll(){
        return service.getAllOffers();
    }

    @GetMapping("/{id}")
    public Optional<Offer> getById(@PathVariable Long id){
        return service.getOfferById(id);
    }

    @PutMapping("/{id}")
    public Offer update(@PathVariable Long id,
                        @RequestBody Offer offer){

        return service.updateOffer(id,offer);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        service.deleteOffer(id);

    }

}