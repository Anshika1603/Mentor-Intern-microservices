package com.knoldus.microservice1.contollerImpl;

import com.knoldus.microservice1.controller.Interncontroller;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class interncontrollerimpl implements Interncontroller {
    @Autowired
    InternService internService;

    @Override
    public ResponseEntity<List<Interns>> fetchAllInternswithMentorId(Integer mentorId) {
          List<Interns> internsList=internService.fetchInternsByMentorId(mentorId);
          return ResponseEntity.ok((internsList));
        }

}
