package com.knoldus.microservice1.serviceImpl;

import com.knoldus.microservice1.exception.ResourceNotFoundException;
import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.dao.H2Reposiotry;
import com.knoldus.microservice1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class MentorServiceImpl implements MentorService {
    @Autowired
    private H2Reposiotry h2Reposiotry;

    @Override
    public List<Mentor> getAllMentor() {
        List<Mentor> listOfMentor = new ArrayList<>();
        h2Reposiotry.findAll().forEach(listOfMentor::add);
        return listOfMentor;
    }

    @Override
    public Mentor getMentorById(int mentorId) {
        Optional<Mentor> optionalMentor = h2Reposiotry.findById(mentorId);
        if(optionalMentor.isPresent()) {
            return optionalMentor.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not Found");
        }
    }

    @Override
    public Mentor addMentor(Mentor mentor) {
     return h2Reposiotry.save(mentor);
    }

    @Override
    public void updateMentor(Mentor mentor) {
        h2Reposiotry.save(mentor);
    }

    @Override
    public void deleteMentor(int mentorId) {
        h2Reposiotry.delete(getMentorById(mentorId));
    }
}
