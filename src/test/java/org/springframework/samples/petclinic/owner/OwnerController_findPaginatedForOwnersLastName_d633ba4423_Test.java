package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_Success() {
        String lastName = "Smith";
        int page = 1;
        Owner owner1 = new Owner();
        owner1.setLastName(lastName);
        Owner owner2 = new Owner();
        owner2.setLastName(lastName);
        List<Owner> ownerList = Arrays.asList(owner1, owner2);
        Page<Owner> ownerPage = new PageImpl<>(ownerList);

        when(owners.findByLastName(anyString(), any(Pageable.class))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastName);
        assertEquals(ownerPage, result);
        verify(owners, times(1)).findByLastName(lastName, PageRequest.of(page - 1, 5));
    }

    @Test
    public void testFindPaginatedForOwnersLastName_NoOwnersFound() {
        String lastName = "Doe";
        int page = 1;
        Page<Owner> ownerPage = Page.empty();

        when(owners.findByLastName(anyString(), any(Pageable.class))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastName);
        assertEquals(ownerPage, result);
        verify(owners, times(1)).findByLastName(lastName, PageRequest.of(page - 1, 5));
    }
}
