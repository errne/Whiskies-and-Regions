package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/{year}")
    public List<Whisky> findWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.findWhiskiesByYear(year);
    }

    @GetMapping(value = "/ofregion/{region}")
    public List<Whisky> getAllWhiskiesByRegion(@PathVariable String region){
        return whiskyRepository.getWhiskiesByRegion(region);
    }

    @GetMapping("/ofdistillery/{distilleryId}/ofage/{age}")
    public List<Whisky> getAllWhiskiesByDistilleryIdAndAge(@PathVariable Long distilleryId, @PathVariable int age){
        return whiskyRepository.getAllWhiskiesByDistilleryIdAndAge(distilleryId, age);
    }





}
