package com.knoldus.microservice1.serviceImpl;

import com.knoldus.microservice1.exception.ResourceNotFoundException;
import com.knoldus.microservice1.model.Mentor;
import com.knoldus.microservice1.dao.PostgresDBRepository;
import com.knoldus.microservice1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MentorServiceImpl implements MentorService {
    @Autowired
    private PostgresDBRepository postgresDBRepository;

    /**
     * Retrieves a list of all Mentor objects from the Postgres database.
     *
     * @return a List of Mentor objects.
     */
    @Override
    public List<Mentor> getAllMentor() {
        List<Mentor> listOfMentor = new ArrayList<>();
        postgresDBRepository.findAll().forEach(listOfMentor::add);
        return listOfMentor;
    }

    /**
     * Retrieves a Model object from the
     * Postgres database with the given mentorId.
     *
     * @return the retrieved EntityModel object.
     * @throws ResourceNotFoundException if the Mentor
     *                                   object is not found in the database.
     */
    @Override
    public Mentor getMentorById(int mentorId) {
        Optional<Mentor> optionalMentor = postgresDBRepository.findById(mentorId);
        if (optionalMentor.isPresent()) {
            return optionalMentor.get();
        } else {
            throw new ResourceNotFoundException("Resource not Found");
        }
    }

    /**
     * Adds a Mentor object to the Postgres database.
     *
     * @param mentor the Mentor object to add.
     * @return the added Mentor object.
     */
    @Override
    public Mentor addMentor(Mentor mentor) {
        return postgresDBRepository.save(mentor);
    }

    /**
     * Updates a Mentor object in the Postgres database.
     *
     * @param mentor the Mentor object to update.
     * @return the updated EntityModel object.
     * @throws ResourceNotFoundException if the Mentor
     *                                   object is not found in the database.
     */
    @Override
    public void updateMentor(Mentor mentor) {
        postgresDBRepository.save(mentor);
    }

    /**
     * Deletes a Mentor object from
     * the Postgres database with the given mentorId.
     *
     * @param mentorId the ID of the Mentor object to delete.
     * @throws ResourceNotFoundException if the EntityModel
     *                                   object is not found in the database.
     */
    @Override
    public void deleteMentor(int mentorId) {
        postgresDBRepository.delete(getMentorById(mentorId));
    }
}
