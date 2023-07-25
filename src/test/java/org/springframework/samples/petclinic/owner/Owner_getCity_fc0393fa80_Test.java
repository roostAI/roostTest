package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.*;

class Owner_getCity_fc0393fa80_Test {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void testGetCityWhenCityIsSet() {
        String city = "New York";
        person.setCity(city);
        assertEquals(city, person.getCity());
    }

    @Test
    void testGetCityWhenCityIsNotSet() {
        assertNull(person.getCity());
    }
}
