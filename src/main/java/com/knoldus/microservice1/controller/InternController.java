package com.knoldus.microservice1.controller;

import com.knoldus.microservice1.model.Interns;
import com.knoldus.microservice1.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InternController {

    @GetMapping("findInternsByMentorId/{mentorId}")
    List<Interns> findInternsByMentor(@PathVariable Integer mentorId);

    @DeleteMapping("deleteIntern/{Id}")
    ResponseEntity<String> deleteIntern(@PathVariable("Id") final int internId);

    @GetMapping("getInternById/{internId}")
    Interns getInternById(@PathVariable final Integer internId);
}
