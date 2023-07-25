package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_getVisits_6fe3ce5852_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetVisitsWhenNoVisits() {
        Collection<Visit> visits = pet.getVisits();
        assertEquals(0, visits.size(), "Expected no visits");
    }

    @Test
    public void testGetVisitsWhenThereAreVisits() {
        Visit visit1 = new Visit();
        Visit visit2 = new Visit();
        Collection<Visit> testVisits = new ArrayList<>();
        testVisits.add(visit1);
        testVisits.add(visit2);
        
        pet.setVisits(testVisits);
        Collection<Visit> visits = pet.getVisits();
        
        assertEquals(2, visits.size(), "Expected two visits");
        assertEquals(testVisits, visits, "Expected fetched visits to match the set visits");
    }
}
