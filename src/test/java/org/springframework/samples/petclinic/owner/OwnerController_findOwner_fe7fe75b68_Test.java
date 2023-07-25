package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController controller;

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testFindOwner_withNullId() {
        Owner result = controller.findOwner(null);
        assertThat(result).isNotNull();
        assertThat(result.getId()).isNull();
    }

    @Test
    public void testFindOwner_withValidId() {
        when(owners.findById(1)).thenReturn(owner);
        Owner result = controller.findOwner(1);
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getFirstName()).isEqualTo("John");
        assertThat(result.getLastName()).isEqualTo("Doe");
    }

    @Test
    public void testFindOwner_withInvalidId() {
        when(owners.findById(2)).thenReturn(null);
        Owner result = controller.findOwner(2);
        assertThat(result).isNull();
    }
}
