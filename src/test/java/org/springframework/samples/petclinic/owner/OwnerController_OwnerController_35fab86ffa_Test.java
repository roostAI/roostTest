package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController_OwnerController_35fab86ffa_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
        ownerRepository = mock(OwnerRepository.class);
    }

    @Test
    public void testOwnerControllerConstructor() {
        OwnerRepository mockOwnerRepository = mock(OwnerRepository.class);
        OwnerController ownerController = new OwnerController();
        assertEquals(mockOwnerRepository, ownerController.getOwners());
    }

    @Test
    public void testOwnerControllerConstructorWithNull() {
        OwnerController ownerController = new OwnerController();
        assertEquals(null, ownerController.getOwners());
    }
}
