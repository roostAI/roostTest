package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Pet_addVisit_99c71f5c31_Test {

    private Pet pet;
    private Visit visit;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        visit = Mockito.mock(Visit.class);
    }

    @Test
    public void testAddVisit() {
        pet.addVisit(visit);
        Set<Visit> visits = pet.getVisits();
        assertTrue(visits.contains(visit));
    }

    @Test
    public void testAddVisitWhenVisitsAlreadyExist() {
        Set<Visit> existingVisits = new HashSet<>();
        existingVisits.add(Mockito.mock(Visit.class));
        pet.getVisits().addAll(existingVisits);

        pet.addVisit(visit);
        Set<Visit> visits = pet.getVisits();
        assertTrue(visits.contains(visit));
    }
}
