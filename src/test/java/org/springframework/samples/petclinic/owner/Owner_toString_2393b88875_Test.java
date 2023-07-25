package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class Owner_toString_2393b88875_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
    }

    @Test
    public void testToString() {
        ReflectionTestUtils.setField(owner, "id", 1);
        ReflectionTestUtils.setField(owner, "new", false);
        ReflectionTestUtils.setField(owner, "lastName", "Doe");
        ReflectionTestUtils.setField(owner, "firstName", "John");
        ReflectionTestUtils.setField(owner, "address", "123 Main St");
        ReflectionTestUtils.setField(owner, "city", "Springfield");
        ReflectionTestUtils.setField(owner, "telephone", "1234567890");

        String expected = "Person: id=1, new=false, lastName='Doe', firstName='John', address='123 Main St', city='Springfield', telephone='1234567890'";
        String actual = owner.toString();

        Assert.isTrue(expected.equals(actual), "Expected and actual toString outputs do not match");
    }

    @Test
    public void testToStringWithNullFields() {
        String expected = "Person: id=null, new=false, lastName=null, firstName=null, address=null, city=null, telephone=null";
        String actual = owner.toString();

        Assert.isTrue(expected.equals(actual), "Expected and actual toString outputs do not match when fields are null");
    }
}
