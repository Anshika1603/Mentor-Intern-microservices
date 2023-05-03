package com.knoldus.microservice1.contollerImpl;

import com.knoldus.microservice1.controller.InternController;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.serviceImpl.InternServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InternControllerImpl implements InternController {
    @Autowired
    InternServiceImpl internServiceImpl;

    @Override
    public List<Interns> findInternsByMentor(Integer mentorId) {
      List<Interns> interns= internServiceImpl.findInternsByMentor(mentorId);
     return interns;
    }

}
