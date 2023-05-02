package com.knoldus.MentorService.controller;

import com.knoldus.MentorService.model.Interns;
import com.knoldus.MentorService.model.Mentor;
import com.knoldus.MentorService.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
