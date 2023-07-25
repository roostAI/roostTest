package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_setBirthDate_990b03b544_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        this.pet = new Pet();
    }

    @Test
    public void testSetBirthDate_withValidDate() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        this.pet.setBirthDate(birthDate);
        assertEquals(birthDate, this.pet.getBirthDate());
    }

    @Test
    public void testSetBirthDate_withNullDate() {
        this.pet.setBirthDate(null);
        assertNull(this.pet.getBirthDate());
    }
}
