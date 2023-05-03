package com.knoldus.microservice1.serviceImpl;

import com.knoldus.microservice1.dao.InternsRepository;
import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
