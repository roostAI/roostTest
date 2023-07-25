package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Person_setLastName_815ee71c38_Test {

    @Mock
    private Person person;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetLastName_success() {
        String lastName = "Smith";
        when(person.getLastName()).thenReturn(lastName);
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }

    @Test
    public void testSetLastName_null() {
        String lastName = null;
        when(person.getLastName()).thenReturn(lastName);
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }
}
