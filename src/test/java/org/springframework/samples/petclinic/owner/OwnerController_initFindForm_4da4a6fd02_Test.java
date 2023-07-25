package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    OwnerController ownerController;

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }
}
