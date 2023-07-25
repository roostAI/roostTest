package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class PetControllerTest {

    private OwnerRepository owners;
    private PetController petController;

    @BeforeEach
    void setUp() {
        owners = Mockito.mock(OwnerRepository.class);
        petController = new PetController();
    }

    @Test
    void testPetControllerConstructor_withValidOwnerRepository() {
        assertNotNull(petController, "PetController should be initialized");
    }

    @Test
    void testPetControllerConstructor_withNullOwnerRepository() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PetController();
        });

        String expectedMessage = "OwnerRepository cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
