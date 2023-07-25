package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetBirthDate() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        LocalDate actualBirthDate = pet.getBirthDate();
        assertEquals(birthDate, actualBirthDate, "The birth dates should match");
    }

    @Test
    public void testGetBirthDateForNull() {
        LocalDate actualBirthDate = pet.getBirthDate();
        assertEquals(null, actualBirthDate, "The birth date should be null");
    }
}
