package com.knoldus.microservice1.service;

import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InternService {
   public  List<Interns> findInternsByMentor(Integer mentorId);

   public ResponseEntity<String> deleteIntern(int internId);

   public Interns getInternById(Integer internId);

}
