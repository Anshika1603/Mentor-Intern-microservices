package com.knoldus.microservice1.controller.impl;

import com.knoldus.microservice1.controller.InternController;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.InternService;
import com.knoldus.microservice1.service.impl.InternServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InternControllerImpl implements InternController {
    @Autowired
    InternService internService;

    @Override
    public List<Interns> findInternsByMentor(Integer mentorId) {
        List<Interns> interns = internService.findInternsByMentor(mentorId);
        return interns;
    }

    @Override
    public ResponseEntity<String> deleteIntern(@PathVariable final int InternId) {
        return internService.deleteIntern(InternId);
    }

    @Override
    public Interns getInternById(@PathVariable final Integer internId) {
        return internService.getInternById(internId);
    }

}
