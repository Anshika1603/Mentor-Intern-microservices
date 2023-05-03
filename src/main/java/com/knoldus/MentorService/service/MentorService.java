package com.knoldus.MentorService.service;

import com.knoldus.MentorService.model.Interns;
import com.knoldus.MentorService.model.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

    public String deleteMentor(Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Mentor> entity = new HttpEntity<Mentor>(headers);
        restTemplate.exchange("http://localhost:8081/deleteMentor/"+id, HttpMethod.DELETE, entity, Mentor.class).getBody();
        return "Record with id: "+id+" deleted";
    }

}
