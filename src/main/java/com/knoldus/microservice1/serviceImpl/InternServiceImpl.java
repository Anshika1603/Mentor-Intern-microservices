package com.knoldus.microservice1.serviceImpl;

import com.knoldus.microservice1.dao.InternsRepository;
import com.knoldus.microservice1.exception.ResourceNotFoundException;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InternServiceImpl implements InternService {
    @Autowired
    InternsRepository internsRepository;


    @Override
    public List<Interns> findInternsByMentor(Integer mentorId) {
        return internsRepository.findInternsByMentor(mentorId);
    }
}
