package com.knoldus.microservice1.service;

import com.knoldus.microservice1.model.Interns;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InternService {

    List<Interns> fetchInternsByMentorId(Integer mentorId);
}
