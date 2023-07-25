package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseEntity_isNew_70b8047511_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    void setUp() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    void testIsNew_withNullId() {
        this.baseEntity.setId(null);
        assertTrue(this.baseEntity.isNew());
    }

    @Test
    void testIsNew_withNonNullId() {
        this.baseEntity.setId(1);
        assertFalse(this.baseEntity.isNew());
    }
}
