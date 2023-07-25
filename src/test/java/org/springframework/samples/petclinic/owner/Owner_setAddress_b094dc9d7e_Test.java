package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class Owner_setAddress_b094dc9d7e_Test {

    @Mock
    private Owner owner;

    @InjectMocks
    private OwnerService ownerService;

    @BeforeEach
    public void setUp() {
        owner = Mockito.mock(Owner.class);
    }

    @Test
    public void testSetAddress() {
        String address = "123 Main Street";
        Mockito.doCallRealMethod().when(owner).setAddress(address);
        Mockito.when(owner.getAddress()).thenReturn(address);
        owner.setAddress(address);
        assertEquals(address, owner.getAddress());
    }

    @Test
    public void testSetAddress_Null() {
        String address = null;
        assertThrows(NullPointerException.class, () -> owner.setAddress(address));
    }
}
