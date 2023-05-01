package com.knoldus.microservice1.controller.interncontroller;

import com.knoldus.microservice1.model.Interns;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface Interncontroller {
    @GetMapping("/getInterns/{id}")
    public ResponseEntity<Interns> fetchAllInternswithMentorId(Integer mentorId);
}
