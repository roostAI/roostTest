package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7a4d72b0e8_Test {

    @InjectMocks
    private Owner owner = new Owner();

    @Mock
    private Pet pet1 = new Pet();

    @Mock
    private Pet pet2 = new Pet();

    @BeforeEach
    public void setup() {
        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);

        owner.setPetsInternal(petList);
    }

    @Test
    public void testGetPet_success() {
        Pet foundPet = owner.getPet("Pet1", false);
        assertEquals(pet1, foundPet, "The returned pet should match the expected pet");
    }

    @Test
    public void testGetPet_petNotFound() {
        Pet foundPet = owner.getPet("Pet3", false);
        assertNull(foundPet, "The returned pet should be null as there is no pet with id 3");
    }
}
