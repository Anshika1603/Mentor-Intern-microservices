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
    public List<Interns> fetchInternsByMentorId(Integer mentorId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Interns> entity = new HttpEntity<Interns>(headers);
        return restTemplate.exchange("http://localhost:8081/internfetch/"+mentorId, HttpMethod.GET, entity, List.class).getBody();
    }

    public List<Mentor> getMentors(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(headers);
        return restTemplate.exchange("http://localhost:8081/getMentor", HttpMethod.GET, entity, List.class).getBody();
    }

    public Mentor addMentors(Mentor mentor){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(mentor,headers);
        return restTemplate.exchange("http://localhost:8081/addMentor", HttpMethod.POST, entity, Mentor.class).getBody();
    }

    public Mentor updateMentors(Mentor mentor,Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(mentor,headers);
        return restTemplate.exchange("http://localhost:8081/updateMentor/"+id, HttpMethod.PUT, entity, Mentor.class).getBody();
    }

    public ResponseEntity<String> deleteMentor(Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(headers);
//        restTemplate.exchange("http://localhost:8081/deleteMentor/"+id, HttpMethod.DELETE, entity, Mentor.class).getBody();
        restTemplate.exchange("http://localhost:8081/deleteMentor/"+id, HttpMethod.DELETE, entity, String.class).getBody();
        return ResponseEntity.ok("the object has been deleted where MentorId = "+id);
    }

    public ResponseEntity<String> deleteIntern(Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Interns> entity = new HttpEntity<Interns>(headers);
        restTemplate.exchange("http://localhost:8081/deleteIntern/"+id, HttpMethod.DELETE, entity, String.class).getBody();
        return ResponseEntity.ok("the object has been deleted where internId = "+id);
    }

    public Interns getInternById(Integer internId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Interns> entity = new HttpEntity<Interns>(headers);
        return restTemplate.exchange("http://localhost:8081/getInternById/"+internId, HttpMethod.GET, entity, Interns.class).getBody();
    }

}
