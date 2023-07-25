package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Owner_getPet_7f0beed2aa_Test {

    private Owner owner;
    private Pet pet;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = mock(Pet.class);
        owner.addPet(pet);
    }

    @Test
    public void testGetPetSuccess() {
        when(pet.getName()).thenReturn("Buddy");
        Pet retrievedPet = owner.getPet("Buddy");
        assertNotNull(retrievedPet);
        assertEquals("Buddy", retrievedPet.getName());
    }

    @Test
    public void testGetPetFailure() {
        when(pet.getName()).thenReturn("Buddy");
        Pet retrievedPet = owner.getPet("Unknown");
        assertNull(retrievedPet);
    }
}
