package com.knoldus.microservice1.serviceImpl.internserviceimpl;

import com.knoldus.microservice1.dao.InternsRepository;
import com.knoldus.microservice1.exception.ResourceNotFoundException;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.internservice.InternService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class InternServiceImpl implements InternService {
    @Autowired
    InternsRepository internsRepository;

    @Override
    public Interns fetchInternsByMentorId(Integer mentorId) {
        Optional<Interns> interns = internsRepository.findById(mentorId);
        if (interns.isPresent()) {
            return interns.get();
        } else {
            throw new ResourceNotFoundException("cannot fetch id in the db");
        }

    }

}
