package com.knoldus.microservice1.dao;

import com.knoldus.microservice1.model.Interns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternsRepository extends JpaRepository<Interns,Integer> {
}
