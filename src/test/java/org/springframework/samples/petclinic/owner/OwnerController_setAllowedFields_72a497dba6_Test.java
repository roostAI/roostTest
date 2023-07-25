package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.WebDataBinder;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(owner, "owner");
        dataBinder = new WebDataBinder(owner);
        dataBinder.setBindingResult(bindingResult);
    }

    @Test
    public void testSetAllowedFields() {
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);

        // Check if "id" field is disallowed
        assertTrue(dataBinder.getDisallowedFields().contains("id"));

        // Try to bind "id" field
        dataBinder.bind(new MutablePropertyValues(Collections.singletonMap("id", 2)));

        // Assert that "id" field is not changed
        assertEquals(1, ((Owner)dataBinder.getTarget()).getId());
    }

    @Test
    public void testSetAllowedFieldsWithNonDisallowedField() {
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);

        // Check if "firstName" field is not disallowed
        assertFalse(dataBinder.getDisallowedFields().contains("firstName"));

        // Try to bind "firstName" field
        dataBinder.bind(new MutablePropertyValues(Collections.singletonMap("firstName", "Jane")));

        // Assert that "firstName" field is changed
        assertEquals("Jane", ((Owner)dataBinder.getTarget()).getFirstName());
    }
}
