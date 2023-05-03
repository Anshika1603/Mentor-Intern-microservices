package com.knoldus.MentorService.controller;

import com.knoldus.MentorService.model.Interns;
import com.knoldus.MentorService.model.Mentor;
import com.knoldus.MentorService.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {

    @Autowired
    MentorService mentorService;

    @GetMapping("/getInterns/{id}")
    public ResponseEntity<List<Interns>> fetchAllInternswithMentorId(@PathVariable("id") Integer mentorId) {
        return ResponseEntity.ok(mentorService.fetchInternsByMentorId(mentorId));
    }

    @GetMapping("/getAllMentors")
    public ResponseEntity<List<Mentor>> getAllMentors(){
        return ResponseEntity.ok(mentorService.getMentors());
    }

    @PostMapping("/addMentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor){
        return ResponseEntity.ok(mentorService.addMentors(mentor));
    }

    @PutMapping("/updateMentor/{id}")
    public ResponseEntity<Mentor> updateMentor(@RequestBody final Mentor mentor, @PathVariable("id") final Integer targetId){
        return ResponseEntity.ok(mentorService.updateMentors(mentor,targetId));
    }

    @DeleteMapping("/deleteMentor/{id}")
    public ResponseEntity<String> deleteMentor(@PathVariable final Integer id){
        return ResponseEntity.ok(mentorService.deleteMentor(id));
    }
}
