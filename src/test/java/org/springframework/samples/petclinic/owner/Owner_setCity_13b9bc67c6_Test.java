package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setCity_13b9bc67c6_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetCity_ValidCity() {
        String validCity = "New York";
        person.setCity(validCity);
        assertEquals(validCity, person.getCity(), "City should be set to New York");
    }

    @Test
    public void testSetCity_EmptyCity() {
        String emptyCity = "";
        person.setCity(emptyCity);
        assertEquals(emptyCity, person.getCity(), "City should be set to empty string");
    }

    @Test
    public void testSetCity_NullCity() {
        String nullCity = null;
        person.setCity(nullCity);
        assertEquals(nullCity, person.getCity(), "City should be set to null");
    }
}
