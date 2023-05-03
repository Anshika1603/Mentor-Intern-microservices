package com.knoldus.microservice1.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mentors")
@Transactional
public final class Mentor {

    /**
     * The Id of the mentor in the database
     */
    @Id
    private Integer mentorId;

    /**
     * The Name of the mentor in the database
     */
    @Column
    private String mentorName;

    /**
     * Intern Entity class
     */

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Mentor_Fk", referencedColumnName = "mentorId")
    private Set<Interns> interns;
}