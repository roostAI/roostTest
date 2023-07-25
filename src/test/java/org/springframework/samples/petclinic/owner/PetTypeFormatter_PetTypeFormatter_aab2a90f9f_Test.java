package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetType;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class PetTypeFormatter_PetTypeFormatter_aab2a90f9f_Test {

    private OwnerRepository owners;

    private PetTypeFormatter petTypeFormatter;

    @BeforeEach
    public void setup() {
        owners = Mockito.mock(OwnerRepository.class);
        petTypeFormatter = new PetTypeFormatter();
    }

    @Test
    public void testPetTypeFormatter_Success() throws ParseException {
        PetType petType = new PetType();
        petType.setName("Dog");
        Collection<PetType> petTypes = Arrays.asList(petType);
        when(owners.findPetTypes()).thenReturn(petTypes);

        PetType parsedPetType = petTypeFormatter.parse("Dog", Locale.ENGLISH);
        assertEquals("Dog", parsedPetType.getName());
    }

    @Test
    public void testPetTypeFormatter_Failure() {
        when(owners.findPetTypes()).thenReturn(null);

        assertThrows(ParseException.class, () -> {
            petTypeFormatter.parse("Dog", Locale.ENGLISH);
        });
    }
}
