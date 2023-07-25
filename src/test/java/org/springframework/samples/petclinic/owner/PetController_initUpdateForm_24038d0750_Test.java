package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

class PetController_initUpdateForm_24038d0750_Test {

    private Owner owner;
    private ModelMap model;
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    @BeforeEach
    void setup() {
        owner = mock(Owner.class);
        model = new ModelMap();
    }

    @Test
    public void testInitUpdateForm_PetExists() {
        Pet pet = new Pet();
        when(owner.getPet(1)).thenReturn(pet);

        String viewName = initUpdateForm(owner, 1, model);

        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, viewName);
        assertSame(pet, model.get("pet"));
    }

    @Test
    public void testInitUpdateForm_PetDoesNotExist() {
        when(owner.getPet(1)).thenReturn(null);

        String viewName = initUpdateForm(owner, 1, model);

        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, viewName);
        assertNull(model.get("pet"));
    }

    private String initUpdateForm(Owner owner, int petId, ModelMap model) {
        Pet pet = owner.getPet(petId);
        model.put("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }
}
