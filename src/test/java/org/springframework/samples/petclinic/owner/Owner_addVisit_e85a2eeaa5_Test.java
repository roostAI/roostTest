package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class Owner_addVisit_e85a2eeaa5_Test {

    @InjectMocks
    Owner owner = new Owner();

    @Mock
    Pet pet = new Pet();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddVisitSuccess() {
        Visit visit = new Visit();
        Integer petId = 1;

        when(owner.getPet(petId)).thenReturn(pet);

        owner.addVisit(petId, visit);

        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        Visit visit = new Visit();
        Integer petId = null;

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(petId, visit));
    }

    @Test
    public void testAddVisitWithNullVisit() {
        Integer petId = 1;

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(petId, null));
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        Visit visit = new Visit();
        Integer petId = 1;

        when(owner.getPet(petId)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(petId, visit));
    }
}
