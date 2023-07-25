package org.springframework.samples.petclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

import static org.mockito.Mockito.verify;

public class PetClinicRuntimeHints_registerHints_b9a071d40e_Test {

    @Mock
    private RuntimeHints hints;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterHints() {
        PetClinicRuntimeHints_registerHints_b9a071d40e registerHints = new PetClinicRuntimeHints_registerHints_b9a071d40e();
        registerHints.registerHints(hints, this.getClass().getClassLoader());

        verify(hints).resources().registerPattern("db/*");
        verify(hints).resources().registerPattern("messages/*");
        verify(hints).resources().registerPattern("META-INF/resources/webjars/*");
        verify(hints).resources().registerPattern("mysql-default-conf");
        verify(hints).serialization().registerType(BaseEntity.class);
        verify(hints).serialization().registerType(Person.class);
        verify(hints).serialization().registerType(Vet.class);
    }
}
