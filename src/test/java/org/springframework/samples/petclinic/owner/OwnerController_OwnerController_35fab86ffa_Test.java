package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class OwnerController_OwnerController_35fab86ffa_Test {

    @Mock
    private OwnerRepository clinicService;

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.ownerController = new OwnerController();
    }

    @Test
    public void testOwnerControllerConstructorSuccess() {
        OwnerRepository mockOwnerRepository = mock(OwnerRepository.class);
        OwnerController ownerController = new OwnerController();
        verify(mockOwnerRepository, times(1)).findAll();
    }

    @Test
    public void testOwnerControllerConstructorFailure() {
        try {
            new OwnerController();
        } catch (IllegalArgumentException e) {
            assertEquals("OwnerRepository must not be null!", e.getMessage());
        }
    }
}
