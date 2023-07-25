package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OwnerController_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(owners);
    }

    @Test
    public void testFindOwner_NullId() {
        Owner result = ownerController.findOwner(null);
        assertNotNull(result);
    }

    @Test
    public void testFindOwner_ValidId() {
        Owner expectedOwner = new Owner();
        when(owners.findById(1)).thenReturn(java.util.Optional.of(expectedOwner));

        Owner result = ownerController.findOwner(1);
        assertEquals(expectedOwner, result);
    }
}
