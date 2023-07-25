package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.style.ToStringCreator;

public class Owner_toString_2393b88875_Test {

    private Owner owner;
    
    @BeforeEach
    public void setup() {
        owner = mock(Owner.class);
    }

    @Test
    public void testToString() {
        when(owner.getId()).thenReturn(1);
        when(owner.isNew()).thenReturn(true);
        when(owner.getLastName()).thenReturn("Doe");
        when(owner.getFirstName()).thenReturn("John");
        when(owner.getAddress()).thenReturn("123 Main St");
        when(owner.getCity()).thenReturn("Springfield");
        when(owner.getTelephone()).thenReturn("123-456-7890");

        String expected = new ToStringCreator(owner)
            .append("id", 1)
            .append("new", true)
            .append("lastName", "Doe")
            .append("firstName", "John")
            .append("address", "123 Main St")
            .append("city", "Springfield")
            .append("telephone", "123-456-7890")
            .toString();

        assertEquals(expected, owner.toString());
    }

    @Test
    public void testToString_NullValues() {
        when(owner.getId()).thenReturn(null);
        when(owner.isNew()).thenReturn(null);
        when(owner.getLastName()).thenReturn(null);
        when(owner.getFirstName()).thenReturn(null);
        when(owner.getAddress()).thenReturn(null);
        when(owner.getCity()).thenReturn(null);
        when(owner.getTelephone()).thenReturn(null);

        String expected = new ToStringCreator(owner)
            .append("id", null)
            .append("new", null)
            .append("lastName", null)
            .append("firstName", null)
            .append("address", null)
            .append("city", null)
            .append("telephone", null)
            .toString();

        assertEquals(expected, owner.toString());
    }
}
