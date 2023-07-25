package org.springframework.samples.petclinic.owner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    OwnerRepository owners = new OwnerRepository();

    @Mock
    BindingResult result = new BindingResult();

    @Mock
    Owner owner = new Owner();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_success() {
        when(result.hasErrors()).thenReturn(false);
        String viewName = ownerController.processUpdateOwnerForm(owner, result, 1);
        verify(owner).setId(1);
        verify(owners).save(any(Owner.class));
        assert("redirect:/owners/{ownerId}".equals(viewName));
    }

    @Test
    public void testProcessUpdateOwnerForm_failure() {
        when(result.hasErrors()).thenReturn(true);
        String viewName = ownerController.processUpdateOwnerForm(owner, result, 1);
        assert("createOrUpdateOwnerForm".equals(viewName));
    }
}
