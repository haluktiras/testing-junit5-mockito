package com.ht.petclinic.services.springdatajpa;

import com.ht.petclinic.model.Speciality;
import com.ht.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void delete() {
        service.deleteById(1L);
    }

    @Test
    void testDelete() {
        service.delete(new Speciality());
    }
}