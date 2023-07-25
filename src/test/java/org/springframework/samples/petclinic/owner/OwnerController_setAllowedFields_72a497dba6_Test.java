package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.*;

class OwnerController_setAllowedFields_72a497dba6_Test {
    private WebDataBinder dataBinder;

    @BeforeEach
    void setUp() {
        Owner owner = new Owner();
        dataBinder = new WebDataBinder(owner, "owner");
    }

    @Test
    void testSetAllowedFields_IdDisallowed() {
        OwnerController ownerController = new OwnerController();
        ownerController.setAllowedFields(dataBinder);
        assertTrue(dataBinder.isDisallowed("id"));
    }

    @Test
    void testSetAllowedFields_OtherFieldsAllowed() {
        OwnerController ownerController = new OwnerController();
        ownerController.setAllowedFields(dataBinder);
        assertFalse(dataBinder.isDisallowed("name"));
    }
}
