package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Owner_getAddress_a51bc89946_Test {

    @MockBean
    private Owner owner;

    @Test
    public void testGetAddressSuccess() {
        String expectedAddress = "123 Street";
        when(owner.getAddress()).thenReturn(expectedAddress);

        String actualAddress = owner.getAddress();

        assertEquals(expectedAddress, actualAddress, "The addresses should match");
    }

    @Test
    public void testGetAddressFailure() {
        String expectedAddress = "123 Street";
        when(owner.getAddress()).thenReturn("456 Avenue");

        String actualAddress = owner.getAddress();

        assertEquals(expectedAddress, actualAddress, "The addresses should not match");
    }
}
