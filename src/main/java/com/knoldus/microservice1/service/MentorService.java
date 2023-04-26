package com.knoldus.microservice1.service;

import com.knoldus.microservice1.model.Mentor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MentorService {

List<Mentor> getAllMentor();

Mentor getMentorById(int mentorId);

Mentor addMentor(Mentor mentor);

void updateMentor(Mentor mentor);

void deleteMentor(int mentorId);
}
