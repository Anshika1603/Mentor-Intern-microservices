package com.knoldus.microservice1.dao;

import com.knoldus.microservice1.model.Interns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternsRepository extends JpaRepository<Interns, Integer> {
    @Query("SELECT i FROM Interns i WHERE i.Mentor_Fk = :Mentor_Fk")
    List<Interns> findInternById(@Param("Mentor_Fk") Integer Mentor_Fk);
}
