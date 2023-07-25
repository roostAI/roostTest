package org.springframework.samples.petclinic.owner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class PetController_populatePetTypes_4b0826342f_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    OwnerRepository owners = Mockito.mock(OwnerRepository.class);

    PetType dog = new PetType();
    PetType cat = new PetType();

    @BeforeEach
    void setup() {
        dog.setId(1);
        dog.setName("Dog");

        cat.setId(2);
        cat.setName("Cat");
    }

    @Test
    public void testPopulatePetTypes() {
        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(2, petTypes.size());
    }

    @Test
    public void testPopulatePetTypes_empty() {
        when(owners.findPetTypes()).thenReturn(Collections.emptyList());
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(0, petTypes.size());
    }
}
