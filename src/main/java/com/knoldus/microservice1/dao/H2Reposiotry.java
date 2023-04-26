package com.knoldus.microservice1.dao;

import com.knoldus.microservice1.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2Reposiotry extends JpaRepository<Mentor, Integer> {
}
