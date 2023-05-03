package com.knoldus.microservice1.dao;

import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternsRepository extends JpaRepository<Interns, Integer> {
    @Query(
           value = "select * from interns s where s.mentor_fk = ?",
                  nativeQuery = true
    )
    List<Interns> findInternsByMentor(Integer mentorId);


}
