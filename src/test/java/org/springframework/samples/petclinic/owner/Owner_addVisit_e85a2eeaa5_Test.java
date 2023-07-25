package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_addVisit_e85a2eeaa5_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet;

    @Test
    public void testAddVisit_Success() {
        Visit visit = new Visit();
        when(owner.getPet(anyInt())).thenReturn(pet);

        owner.addVisit(1, visit);

        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisit_PetIdIsNull() {
        Visit visit = new Visit();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, visit);
        });

        String expectedMessage = "Pet identifier must not be null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddVisit_VisitIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, null);
        });

        String expectedMessage = "Visit must not be null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddVisit_PetNotFound() {
        Visit visit = new Visit();
        when(owner.getPet(anyInt())).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, visit);
        });

        String expectedMessage = "Invalid Pet identifier!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
