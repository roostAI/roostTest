package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetTypeFormatterPrintBd9d8d12f6Test {

    private Formatter<PetType> petTypeFormatter;

    @Mock
    private PetType petType;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        petTypeFormatter = new PetTypeFormatter();
    }

    @Test
    public void testPrintSuccess() {
        when(petType.getName()).thenReturn("Dog");
        String result = petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals("Dog", result);
    }

    @Test
    public void testPrintFailure() {
        when(petType.getName()).thenReturn("Cat");
        String result = petTypeFormatter.print(petType, Locale.ENGLISH);
        assertEquals("Dog", result);
    }
}
