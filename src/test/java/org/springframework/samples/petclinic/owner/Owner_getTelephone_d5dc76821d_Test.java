package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class Owner_getTelephone_d5dc76821d_Test {

    @InjectMocks
    private Person owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        owner = new Person();
    }

    @Test
    public void testGetTelephoneWhenTelephoneIsSet() {
        String expectedTelephone = "1234567890";
        owner.setTelephone(expectedTelephone);
        String actualTelephone = owner.getTelephone();
        assertEquals(expectedTelephone, actualTelephone);
    }

    @Test
    public void testGetTelephoneWhenTelephoneIsNotSet() {
        String actualTelephone = owner.getTelephone();
        assertNull(actualTelephone);
    }
}
