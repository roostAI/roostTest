package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BaseEntity_getId_09ace845cd_Test {

    @Mock
    private BaseEntity baseEntity;

    @InjectMocks
    BaseEntity_getId_09ace845cd_Test baseEntity_getId_09ace845cd_Test;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(baseEntity.getId()).thenReturn(1);
    }

    @Test
    public void testGetIdSuccess() {
        assertEquals(1, baseEntity.getId().intValue(), "Expected and actual id do not match.");
    }

    @Test
    public void testGetIdFailure() {
        when(baseEntity.getId()).thenReturn(null);
        assertEquals(null, baseEntity.getId(), "Expected null but got a value.");
    }
}
