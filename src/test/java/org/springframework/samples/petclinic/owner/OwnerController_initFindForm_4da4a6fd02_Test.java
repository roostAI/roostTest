package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerController_initFindForm_4da4a6fd02_Test {

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        ownerController = new OwnerController();
    }

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findPets", viewName);
    }
}
