package com.knoldus.MentorService.model;

import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents an intern in the organization.
 * It contains the intern's ID, name, phone number, and address details.
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Interns {

    /**
     * The ID of the intern.
     */
    private Integer internId;

    /**
     * The name of the intern.
     */
    private String name;

    /**
     * The phone number of the intern.
     */
    Integer phoneNumber;


    /**
     * The address of the intern.
     */
    @Embedded
    private Address address;



}
