package com.knoldus.MentorService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class Mentor {

    /**
     * The ID of the mentor.
     */
    private Integer mentorId;

    /**
     * The name of the mentor.
     */
    private String mentorName;

    /**
     * The set of interns who are under this mentor.
     */
    private Set<Interns> interns;
}
