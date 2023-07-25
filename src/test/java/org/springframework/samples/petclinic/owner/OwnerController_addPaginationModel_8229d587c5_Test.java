package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    private Model model;
    private Page<Owner> paginated;

    @Before
    public void setUp() {
        model = mock(Model.class);
        paginated = mock(Page.class);
    }

    @Test
    public void testAddPaginationModel() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        List<Owner> owners = Arrays.asList(owner1, owner2);
        int page = 1;

        when(paginated.getContent()).thenReturn(owners);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn((long) owners.size());

        String view = addPaginationModel(page, model, paginated);

        assertEquals("owners/ownersList", view);
    }

    @Test
    public void testAddPaginationModel_EmptyPage() {
        List<Owner> owners = Arrays.asList();
        int page = 1;

        when(paginated.getContent()).thenReturn(owners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn((long) owners.size());

        String view = addPaginationModel(page, model, paginated);

        assertEquals("owners/ownersList", view);
    }

    private String addPaginationModel(int page, Model model, Page<Owner> paginated) {
        model.addAttribute("listOwners", paginated);
        List<Owner> listOwners = paginated.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", paginated.getTotalPages());
        model.addAttribute("totalItems", paginated.getTotalElements());
        model.addAttribute("listOwners", listOwners);
        return "owners/ownersList";
    }
}
