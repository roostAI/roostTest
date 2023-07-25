package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

public class PetController_processUpdateForm_e1332752ad_Test {

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
        petController = new PetController();
        owner = new Owner();
        pet = new Pet();
        model = new ModelMap();
    }

    @Test
    public void testProcessUpdateForm_success() {
        when(pet.getName()).thenReturn("Rex");
        when(owner.getPet("rex", false)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now().minusDays(1));
        when(result.hasErrors()).thenReturn(false);

        String view = petController.processUpdateForm(pet, result, owner, model);

        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateForm_failure() {
        when(pet.getName()).thenReturn("Rex");
        Pet existingPet = new Pet();
        existingPet.setId(2);
        when(owner.getPet("rex", false)).thenReturn(existingPet);
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));
        when(result.hasErrors()).thenReturn(true);

        String view = petController.processUpdateForm(pet, result, owner, model);

        assertEquals("pets/createOrUpdatePetForm", view);
    }
}
