package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testToString_WithName() {
        namedEntity.setName("TestName");
        String result = namedEntity.toString();
        assertEquals("TestName", result, "Expected and actual results do not match");
    }

    @Test
    public void testToString_WithoutName() {
        namedEntity.setName(null);
        String result = namedEntity.toString();
        assertEquals(null, result, "Expected and actual results do not match");
    }
}
