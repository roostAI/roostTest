package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Owner_addPet_8df3885a5e_Test {

    @Mock
    private Pet pet;

    private Owner owner;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        owner = new Owner();
    }

    @Test
    public void testAddPet() {
        when(pet.isNew()).thenReturn(true);
        owner.addPet(pet);
        List<Pet> pets = new ArrayList<>(owner.getPets());
        assertEquals(1, pets.size());
        assertEquals(pet, pets.get(0));
    }

    @Test
    public void testAddPetWhenPetIsNotNew() {
        when(pet.isNew()).thenReturn(false);
        owner.addPet(pet);
        List<Pet> pets = new ArrayList<>(owner.getPets());
        assertEquals(0, pets.size());
    }
}
