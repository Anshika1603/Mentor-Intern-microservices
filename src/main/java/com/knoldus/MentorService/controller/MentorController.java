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
    /**
     * The logger object is used to log various messages and events that occur during runtime.
     */
    static Logger logger = LoggerFactory.getLogger(MentorController.class);

    @Autowired
    MentorService mentorService;

    /**
     * This method maps GET requests to "/getInterns/{id}" and returns a ResponseEntity containing a List of Interns
     * associated with a given Mentor ID.
     *
     * @param mentorId The ID of the mentor whose interns are to be fetched.
     * @return A ResponseEntity containing a List of Interns associated with the given Mentor ID.
     */
    @GetMapping("/getInterns/{id}")
    public ResponseEntity<List<Interns>> fetchAllInternswithMentorId(@PathVariable("id") Integer mentorId) {
        logger.debug("Fetching interns for mentor with ID: {}", mentorId);
        List<Interns> interns = mentorService.fetchInternsByMentorId(mentorId);
        logger.info("Found {} interns for mentor with ID: {}", interns.size(), mentorId);
        return ResponseEntity.ok(interns);
    }

    /**
     * This method maps GET requests to "/getAllMentors" and returns a ResponseEntity containing a List of all Mentors.
     *
     * @return A ResponseEntity containing a List of all Mentors.
     */
    @GetMapping("/getAllMentors")
    public ResponseEntity<List<Mentor>> getAllMentors() {
        logger.info("Fetching all mentors...");
        List<Mentor> mentors = mentorService.getMentors();
        logger.info("Found {} mentors", mentors.size());
        return ResponseEntity.ok(mentors);
    }

    /**
     * This method maps POST requests to "/addMentor" and adds a new Mentor to the database.
     *
     * @param mentor The Mentor object to be added to the database.
     * @return A ResponseEntity containing the added Mentor object.
     */
    @PostMapping("/addMentor")
    public ResponseEntity<Mentor> addMentor(@RequestBody final Mentor mentor) {
        logger.info("Adding mentor: {}", mentor);
        Mentor addedMentor = mentorService.addMentors(mentor);
        logger.info("Added mentor: {}", addedMentor);
        return ResponseEntity.ok(addedMentor);
    }

    /**
     * This method maps PUT requests to "/updateMentor/{id}" and updates the details of a Mentor with a given ID.
     *
     * @param mentor The updated Mentor object.
     * @param targetId The ID of the Mentor to be updated.
     * @return A ResponseEntity containing the updated Mentor object.
     */
    @PutMapping("/updateMentor/{id}")
    public ResponseEntity<Mentor> updateMentor(@RequestBody final Mentor mentor, @PathVariable("id") final Integer targetId) {
        logger.info("Updating mentor with ID: {} with data: {}", targetId, mentor);
        Mentor updatedMentor = mentorService.updateMentors(mentor, targetId);
        logger.info("Updated mentor: {}", updatedMentor);
        return ResponseEntity.ok(updatedMentor);
    }

    /**
     * This method maps DELETE requests to "/deleteMentor/{id}" and deletes the Mentor with the given ID.
     *
     * @param id The ID of the Mentor to be deleted.
     * @return A ResponseEntity containing a message indicating whether the deletion was successful or not.
     */
    @DeleteMapping("/deleteMentor/{id}")
    public ResponseEntity<String> deleteMentor(@PathVariable final Integer id) {
        logger.info("Deleting mentor with ID: {}", id);
        String message = String.valueOf(mentorService.deleteMentor(id));
        logger.info("Delete status: {}", message);
        return ResponseEntity.ok(message);
    }

    /**
     * This method maps DELETE requests to "/deleteIntern/{id}" and deletes the Intern with the given ID.
     *
     * @param id The ID of the Intern to be deleted.
     * @return A ResponseEntity containing a message indicating whether the deletion was successful or not.
     */
    @DeleteMapping("/deleteIntern/{id}")
    public ResponseEntity<String> deleteIntern(@PathVariable("id") final Integer id){
        logger.debug("Deleting intern with ID: {}", id);
        String deleteResponse = String.valueOf(mentorService.deleteIntern(id));
        logger.info("Delete response for intern with ID {}: {}", id, deleteResponse);
        return ResponseEntity.ok(deleteResponse);
    }

    /**
     * This method maps GET requests to "/getInternById/{internId}" and returns a ResponseEntity containing Intern
     * associated with a given Intern ID.
     *
     * @param id The ID of the intern whose intern details are to be fetched.
     * @return A ResponseEntity containing a Intern associated with the given Intern ID.
     */
    @GetMapping("/getInternById/{internId}")
    public ResponseEntity<Interns> getInternById(@PathVariable("internId") final Integer id){
        logger.debug("Fetching intern with ID: {}", id);
        Interns intern = mentorService.getInternById(id);
        logger.info("Found intern with ID {}: {}", id, intern);
        return ResponseEntity.ok(intern);
    }
}
