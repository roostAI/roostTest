package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PetController_initPetBinder_b0b1928cff_Test {

    @InjectMocks
    private PetController petController = new PetController();

    @Mock
    private WebDataBinder dataBinder = new WebDataBinder();

    @Test
    public void testInitPetBinder() {
        petController.initPetBinder(dataBinder);

        PetValidator petValidator = new PetValidator();
        verify(dataBinder).setValidator(petValidator);
    }

    @Test
    public void testInitPetBinderWithNullDataBinder() {
        petController.initPetBinder(null);

        verify(dataBinder, never()).setValidator(any(PetValidator.class));
    }
}
