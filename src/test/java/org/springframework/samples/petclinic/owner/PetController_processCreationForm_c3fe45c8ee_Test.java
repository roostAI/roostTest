package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

public class PetController_processCreationForm_c3fe45c8ee_Test {

    @InjectMocks
    private PetController petController;

    @Mock
    private Owner owner;

    @Mock
    private Pet pet;

    @Mock
    private BindingResult result;

    @Mock
    private ModelMap model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessCreationForm_duplicateName() {
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Fido", true)).thenReturn(pet);

        String view = petController.processCreationForm(owner, pet, result, model);

        verify(result).rejectValue("name", "duplicate", "already exists");
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessCreationForm_futureBirthDate() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processCreationForm(owner, pet, result, model);

        verify(result).rejectValue("birthDate", "typeMismatch.birthDate");
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessCreationForm_success() {
        when(result.hasErrors()).thenReturn(false);
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Fido", true)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now());

        String view = petController.processCreationForm(owner, pet, result, model);

        verify(owner).addPet(pet);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
