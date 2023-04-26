package com.knoldus.microservice1.controller;

import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {
    @Autowired
    private MentorService mentorService;

    @GetMapping("/getMentor")
        public ResponseEntity<List<Mentor>> getAllMentor() {
            List<Mentor> listOfMentor=mentorService.getAllMentor();
            return new ResponseEntity<>(listOfMentor, HttpStatus.OK);
        }

    @GetMapping("/getMentor/{id}")
    public ResponseEntity<Mentor> getMentorById(@PathVariable("id") final int id) {
        Mentor mentor=mentorService.getMentorById(id);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @PostMapping("/addMentor")
    public Mentor addMentor(@RequestBody final Mentor mentor) {
        mentorService.addMentor(mentor);
        return mentor;
    }

    @PutMapping("/updateMentor/{id}")
    public ResponseEntity<Mentor> updateMentor(@RequestBody final Mentor mentor) {
        mentorService.updateMentor(mentor);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMentor/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable final int id) {
        mentorService.deleteMentor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
