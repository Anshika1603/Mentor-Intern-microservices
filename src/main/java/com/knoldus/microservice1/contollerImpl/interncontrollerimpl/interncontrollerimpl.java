package com.knoldus.microservice1.contollerImpl.interncontrollerimpl;

import com.knoldus.microservice1.controller.interncontroller.Interncontroller;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.internservice.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class interncontrollerimpl implements Interncontroller {
    @Autowired
    InternService internService;

    @Override
    public ResponseEntity<Interns> fetchAllInternswithMentorId(Integer mentorId) {
       return ResponseEntity.ok(internService.fetchInternsByMentorId(mentorId));
    }

}
