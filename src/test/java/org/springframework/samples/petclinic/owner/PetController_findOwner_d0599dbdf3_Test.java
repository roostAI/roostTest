package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PetController_findOwner_d0599dbdf3_Test {

    @InjectMocks
    PetController petController;

    @Mock
    OwnerRepository owners;

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testFindOwner_success() {
        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));

        Owner result = petController.findOwner(1);
        assertEquals(owner, result);
    }

    @Test
    public void testFindOwner_failure() {
        when(owners.findById(1)).thenReturn(java.util.Optional.empty());

        Owner result = petController.findOwner(1);
        assertEquals(null, result);
    }
}
