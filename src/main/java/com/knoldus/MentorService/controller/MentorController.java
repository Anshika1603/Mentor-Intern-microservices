package com.knoldus.MentorService.controller;

import com.knoldus.MentorService.model.Interns;
import com.knoldus.MentorService.model.Mentor;
import com.knoldus.MentorService.service.MentorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {
    static Logger logger = LoggerFactory.getLogger(MentorController.class);

    @Autowired
    MentorService mentorService;

    @GetMapping("/getInterns/{id}")
    public ResponseEntity<List<Interns>> fetchAllInternswithMentorId(@PathVariable("id") Integer mentorId) {
        logger.debug("Fetching interns for mentor with ID: {}", mentorId);
        List<Interns> interns = mentorService.fetchInternsByMentorId(mentorId);
        logger.info("Found {} interns for mentor with ID: {}", interns.size(), mentorId);
        return ResponseEntity.ok(interns);
    }

    @GetMapping("/getAllMentors")
    public ResponseEntity<List<Mentor>> getAllMentors() {
        logger.info("Fetching all mentors...");
        List<Mentor> mentors = mentorService.getMentors();
        logger.info("Found {} mentors", mentors.size());
        return ResponseEntity.ok(mentors);
    }



    @PostMapping("/addMentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor) {
        logger.info("Adding mentor: {}", mentor);
        Mentor addedMentor = mentorService.addMentors(mentor);
        logger.info("Added mentor: {}", addedMentor);
        return ResponseEntity.ok(addedMentor);
    }


    @PutMapping("/updateMentor/{id}")
    public ResponseEntity<Mentor> updateMentor(@RequestBody final Mentor mentor, @PathVariable("id") final Integer targetId) {
        logger.info("Updating mentor with ID: {} with data: {}", targetId, mentor);
        Mentor updatedMentor = mentorService.updateMentors(mentor, targetId);
        logger.info("Updated mentor: {}", updatedMentor);
        return ResponseEntity.ok(updatedMentor);
    }


    @DeleteMapping("/deleteMentor/{id}")
    public ResponseEntity<String> deleteMentor(@PathVariable final Integer id) {
        logger.info("Deleting mentor with ID: {}", id);
        String message = String.valueOf(mentorService.deleteMentor(id));
        logger.info("Delete status: {}", message);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/deleteIntern/{id}")
    public ResponseEntity<String> deleteIntern(@PathVariable("id") final Integer id){
        logger.debug("Deleting intern with ID: {}", id);
        String deleteResponse = String.valueOf(mentorService.deleteIntern(id));
        logger.info("Delete response for intern with ID {}: {}", id, deleteResponse);
        return ResponseEntity.ok(deleteResponse);
    }

    @GetMapping("/getInternById/{internId}")
    public ResponseEntity<Interns> getInternById(@PathVariable("internId") final Integer id){
        logger.debug("Fetching intern with ID: {}", id);
        Interns intern = mentorService.getInternById(id);
        logger.info("Found intern with ID {}: {}", id, intern);
        return ResponseEntity.ok(intern);
    }
}
