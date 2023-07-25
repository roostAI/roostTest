package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner_getPets_625ddd4069_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet1.setName("Rex");
        pet2 = new Pet();
        pet2.setName("Fido");
    }

    @Test
    public void testGetPets() {
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);
        owner.setPets(pets);
        List<Pet> returnedPets = owner.getPets();
        assertEquals(2, returnedPets.size());
        assertEquals("Rex", returnedPets.get(0).getName());
        assertEquals("Fido", returnedPets.get(1).getName());
    }
    
    @Test
    public void testGetPetsWhenNoPets() {
        List<Pet> returnedPets = owner.getPets();
        assertNull(returnedPets);
    }
}
