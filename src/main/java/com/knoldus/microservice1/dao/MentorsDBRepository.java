package com.knoldus.microservice1.dao;

import com.knoldus.microservice1.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorsDBRepository extends JpaRepository<Mentor, Integer> {

    @Query("SELECT m FROM Mentor m LEFT JOIN FETCH m.interns")
    List<Mentor> findAllMentors();

}
