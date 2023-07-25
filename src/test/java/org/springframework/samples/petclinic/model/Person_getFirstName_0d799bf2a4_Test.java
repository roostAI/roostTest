package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonGetFirstNameTest {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetFirstName_WhenFirstNameIsSet() {
        String expectedFirstName = "John";
        person.setFirstName(expectedFirstName);
        String actualFirstName = person.getFirstName();
        assertEquals(expectedFirstName, actualFirstName, "First name should match");
    }

    @Test
    public void testGetFirstName_WhenFirstNameIsNotSet() {
        String expectedFirstName = null;
        String actualFirstName = person.getFirstName();
        assertEquals(expectedFirstName, actualFirstName, "First name should be null");
    }
}
