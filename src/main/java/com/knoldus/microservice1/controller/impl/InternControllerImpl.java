package com.knoldus.microservice1.controller.impl;

import com.knoldus.microservice1.controller.InternController;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class InternControllerImpl implements InternController {
    @Autowired
    InternService internService;

    private static final Logger logger = LoggerFactory.getLogger(InternControllerImpl.class);

    @Override
    public List<Interns> findInternsByMentor(Integer mentorId) {
        logger.info("Finding interns by mentorId: {}", mentorId);
        List<Interns> interns = internService.findInternsByMentor(mentorId);
        logger.info("Found interns: {}", interns);
        return interns;
    }

    @Override
    public ResponseEntity<String> deleteIntern(@PathVariable final int internId) {
        logger.info("Deleting intern with internId: {}", internId);
        ResponseEntity<String> response = internService.deleteIntern(internId);
        logger.info("Response from deleteIntern: {}", response);
        return response;
    }

    @Override
    public Interns getInternById(@PathVariable final Integer internId) {
        logger.info("Finding intern by internId: {}", internId);
        Interns intern = internService.getInternById(internId);
        logger.info("Found intern: {}", intern);
        return intern;
    }

}
