package com.knoldus.microservice1.service.impl;

import com.knoldus.microservice1.dao.InternsRepository;
import com.knoldus.microservice1.exception.ResourceNotFoundException;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link InternService} interface.
 */


@Component
public class InternServiceImpl implements InternService {
    @Autowired
    InternsRepository internsRepository;

    /**
     * Returns a list of all Interns associated with a particular Mentor.
     * @param mentorId the ID of the Mentor
     * @return a list of Interns associated with the specified Mentor
     */

    @Override
    public List<Interns> findInternsByMentor(Integer mentorId) {
        return internsRepository.findInternsByMentor(mentorId);
    }

    @Override
    public Interns getInternById(Integer internId) {
        Optional<Interns> optionalInterns = internsRepository.findById(internId);
        if (optionalInterns.isPresent()) {
            return optionalInterns.get();
        } else {
            throw new ResourceNotFoundException("Resource not Found");
        }
    }

    @Override
    public ResponseEntity<String> deleteIntern(int internId){
        Optional<Interns> interns= internsRepository.findById(internId);
        if(interns.isPresent()){
            internsRepository.delete(getInternById(internId));
            return ResponseEntity.ok("the object has been deleted "+internId);
        }
        else {
            throw new ResourceNotFoundException("details not found on particular id");
        }
    }
}
