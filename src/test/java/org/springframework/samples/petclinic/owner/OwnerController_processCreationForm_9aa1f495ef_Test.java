package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

@RunWith(MockitoJUnitRunner.class)
public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @InjectMocks
    private OwnerController ownerController;

    @Before
    public void setup() {
        when(owner.getId()).thenReturn(1);
    }

    @Test
    public void testProcessCreationForm_Success() {
        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processCreationForm(owner, result);

        verify(owners, times(1)).save(any(Owner.class));
        assert ("redirect:/owners/" + owner.getId()).equals(view);
    }

    @Test
    public void testProcessCreationForm_HasErrors() {
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processCreationForm(owner, result);

        verify(owners, times(0)).save(any(Owner.class));
        assert ("owners/createOrUpdateOwnerForm").equals(view);
    }
}
