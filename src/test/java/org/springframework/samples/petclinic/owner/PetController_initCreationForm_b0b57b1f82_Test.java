package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PetController_initCreationForm_b0b57b1f82_Test {

    @Mock
    private Owner owner;

    @Mock
    private ModelMap model;

    @InjectMocks
    private PetController petController;

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    @BeforeEach
    public void setup() {
        petController = new PetController();
    }

    @Test
    public void testInitCreationForm() {
        String view = petController.initCreationForm(owner, model);
        verify(owner).addPet(any(Pet.class));
        verify(model).put(eq("pet"), any(Pet.class));
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
    }

    @Test
    public void testInitCreationFormWithNullOwner() {
        String view = petController.initCreationForm(null, model);
        verify(model).put(eq("pet"), any(Pet.class));
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
    }

    @Test
    public void testInitCreationFormWithNullModel() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            petController.initCreationForm(owner, null);
        });
        assertEquals("ModelMap cannot be null", exception.getMessage());
    }
}
