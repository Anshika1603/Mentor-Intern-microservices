package com.knoldus.MentorService.service;

import com.knoldus.MentorService.exception.ResourceNotFoundException;
import com.knoldus.MentorService.model.Interns;
import com.knoldus.MentorService.model.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    RestTemplate restTemplate;
    /**
     * Returns a list of all Interns associated with a particular Mentor by making a GET request to the external service.
     * @param mentorId the ID of the Mentor
     * @return a list of Interns associated with the specified Mentor
     */
    public List<Interns> fetchInternsByMentorId(Integer mentorId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Interns> entity = new HttpEntity<Interns>(headers);
        return restTemplate.exchange("http://localhost:8081/findInternsByMentorId/"+mentorId, HttpMethod.GET, entity, List.class).getBody();
    }

    /**
    * Returns a list of all Mentors by making a GET request to the external service.
    * @return a list of all Mentors
     */
    public List<Mentor> getMentors(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(headers);
        return restTemplate.exchange("http://localhost:8081/getMentor", HttpMethod.GET, entity, List.class).getBody();
    }

    /**
    * Adds a new Mentor by making a POST request to the external service.
    * @param mentor the Mentor object to be added
    * @return the newly added Mentor object
     */
    public Mentor addMentors(Mentor mentor){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(mentor,headers);
        return restTemplate.exchange("http://localhost:8081/addMentor", HttpMethod.POST, entity, Mentor.class).getBody();
    }

    /**
    * Updates an existing Mentor by making a PUT request to the external service.
    * @param mentor the Mentor object to be updated
    * @param id the ID of the Mentor to be updated
    * @return the updated Mentor object
     */
    public Mentor updateMentors(Mentor mentor,Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(mentor,headers);
        return restTemplate.exchange("http://localhost:8081/updateMentor/"+id, HttpMethod.PUT, entity, Mentor.class).getBody();
    }

    /**
    * Deletes a Mentor object with the specified ID by making a DELETE request to the external service.
    * @param id the ID of the Mentor object to be deleted
    * @return the ResponseEntity with the success message
     */
    public ResponseEntity<String> deleteMentor(Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(headers);
//        restTemplate.exchange("http://localhost:8081/deleteMentor/"+id, HttpMethod.DELETE, entity, Mentor.class).getBody();
        restTemplate.exchange("http://localhost:8081/deleteMentor/"+id, HttpMethod.DELETE, entity, String.class).getBody();
        return ResponseEntity.ok("the object has been deleted where MentorId = "+id);
    }

    /**
    * Deletes an Intern object with the specified ID by making a DELETE request to the external service.
    * @param id the ID of the Intern object to be deleted
    * @return the ResponseEntity with the success message
     */
    public ResponseEntity<String> deleteIntern(Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Interns> entity = new HttpEntity<Interns>(headers);
        restTemplate.exchange("http://localhost:8081/deleteIntern/"+id, HttpMethod.DELETE, entity, String.class).getBody();
        return ResponseEntity.ok("the object has been deleted where internId = "+id);
    }

    /**
    * Retrieves the Intern object corresponding to the given internId.
    * @param internId the ID of the intern whose details are to be retrieved
    * @return an Interns object containing the details of the specified intern
     */
    public Interns getInternById(Integer internId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Interns> entity = new HttpEntity<Interns>(headers);
        return restTemplate.exchange("http://localhost:8081/getInternById/"+internId, HttpMethod.GET, entity, Interns.class).getBody();
    }

}
