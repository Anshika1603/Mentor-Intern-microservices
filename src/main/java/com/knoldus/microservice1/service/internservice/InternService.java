package com.knoldus.microservice1.service.internservice;

import com.knoldus.microservice1.model.Interns;

public interface InternService {

    Interns fetchInternsByMentorId(Integer mentorId);
}
