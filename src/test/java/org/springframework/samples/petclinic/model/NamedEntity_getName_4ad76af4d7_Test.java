package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.NamedEntity;

public class NamedEntity_getName_4ad76af4d7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        this.namedEntity = new NamedEntity();
    }

    @Test
    public void testGetName_Success() {
        String expectedName = "Test Name";
        this.namedEntity.setName(expectedName);
        String actualName = this.namedEntity.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetName_Null() {
        String expectedName = null;
        this.namedEntity.setName(expectedName);
        String actualName = this.namedEntity.getName();
        assertEquals(expectedName, actualName);
    }
}
