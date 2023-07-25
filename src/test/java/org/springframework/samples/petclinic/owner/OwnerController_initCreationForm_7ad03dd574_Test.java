package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initCreationForm_7ad03dd574_Test {

    @Mock
    Model model;

    @InjectMocks
    OwnerController ownerController;

    @Test
    public void testInitCreationForm() {
        Map<String, Object> modelMap = new HashMap<>();
        when(model.asMap()).thenReturn(modelMap);

        String view = ownerController.initCreationForm(model);

        verify(model).asMap();
        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertEquals(new Owner(), modelMap.get("owner"));
    }

    @Test
    public void testInitCreationFormWithExistingOwner() {
        Map<String, Object> modelMap = new HashMap<>();
        Owner owner = new Owner();
        modelMap.put("owner", owner);
        when(model.asMap()).thenReturn(modelMap);

        String view = ownerController.initCreationForm(model);

        verify(model).asMap();
        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertEquals(owner, modelMap.get("owner"));
    }
}
