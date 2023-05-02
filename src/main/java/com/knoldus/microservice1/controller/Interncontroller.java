package com.knoldus.microservice1.controller;

import com.knoldus.microservice1.model.Interns;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Interncontroller {

    @GetMapping("internfetch/{mentorId}")
    public  List<Interns> findInternsByMentor(@PathVariable Integer mentorId);

}
