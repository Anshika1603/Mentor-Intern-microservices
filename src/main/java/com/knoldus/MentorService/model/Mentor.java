package com.knoldus.MentorService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class Mentor {
    private Integer mentorId;
    private String mentorName;

    private Set<Interns> interns;
}
