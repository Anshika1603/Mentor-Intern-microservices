package com.knoldus.microservice1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mentors")
public final class Mentor {

    /**
     * The Id of the mentor in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorId;

    /**
     * The Name of the mentor in the database
     */
    @Column
    private String mentorName;
}
