package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController_initCreationForm_7ad03dd574_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Map<String, Object> model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitCreationForm() {
        String viewName = ownerController.initCreationForm(model);

        verify(model).put("owner", new Owner());
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", viewName);
    }

    @Test
    public void testInitCreationFormWithDifferentViewName() {
        String differentViewName = "DIFFERENT_VIEW_NAME";
        when(ownerController.initCreationForm(model)).thenReturn(differentViewName);

        String viewName = ownerController.initCreationForm(model);

        verify(model).put("owner", new Owner());
        assertEquals(differentViewName, viewName);
    }
}
