package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetController_initOwnerBinder_ae5e2b131f_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        this.dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testInitOwnerBinder_disallowedId() {
        PetController controller = new PetController();
        controller.initOwnerBinder(this.dataBinder);
        verify(this.dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinder_noDisallowedFieldsSet() {
        PetController controller = new PetController();
        controller.initOwnerBinder(this.dataBinder);
        verify(this.dataBinder, never()).setDisallowedFields("name");
    }
}
