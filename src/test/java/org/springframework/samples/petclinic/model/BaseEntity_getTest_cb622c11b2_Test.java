package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_getTest_cb622c11b2_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testGetTest_WhenTestValueIsSet() {
        String expectedValue = "Test Value";
        baseEntity.setTest(expectedValue);
        String actualValue = baseEntity.getTest();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetTest_WhenTestValueIsNotSet() {
        String actualValue = baseEntity.getTest();
        assertEquals(null, actualValue);
    }
}
