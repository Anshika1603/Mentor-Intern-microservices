package com.knoldus.microservice1.service;

import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InternService {
   public  List<Interns> findInternsByMentor(Integer mentorId);


}
