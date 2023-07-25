package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.util.Assert;

public class Owner_setTelephone_df0456699c_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetTelephoneSuccess() {
        String telephone = "1234567890";
        owner.setTelephone(telephone);
        Assert.isTrue(owner.getTelephone().equals(telephone), "Telephone should be set correctly");
    }

    @Test
    public void testSetTelephoneNull() {
        owner.setTelephone(null);
        Assert.isNull(owner.getTelephone(), "Telephone should be null");
    }

    @Test
    public void testSetTelephoneEmpty() {
        String telephone = "";
        owner.setTelephone(telephone);
        Assert.isTrue(owner.getTelephone().equals(telephone), "Telephone should be empty");
    }

    // TODO: Add more test cases for edge cases if necessary
}
