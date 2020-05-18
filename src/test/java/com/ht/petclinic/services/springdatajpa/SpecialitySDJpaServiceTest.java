package com.ht.petclinic.services.springdatajpa;

import com.ht.petclinic.model.Speciality;
import com.ht.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    Speciality speciality;

    @BeforeEach
    void setUp() {
        speciality = new Speciality();
    }

    @Test
    void findAll_test() {
        Set<Speciality> specialtySet = new HashSet<>();
        specialtySet.add(speciality);

        when(specialtyRepository.findAll()).thenReturn(specialtySet);

        Set<Speciality> foundSpecialitySet = service.findAll();

        verify(specialtyRepository).findAll();

        assertThat(foundSpecialitySet).isNotNull();
        assertThat(foundSpecialitySet).hasSize(1);
    }

    @Test
    void testDeleteByObject() {
        Speciality speciality = new Speciality();

        service.delete(speciality);

        verify(specialtyRepository).delete(any(Speciality.class));
    }

    @Test
    void findByIdTest() {
        Speciality speciality = new Speciality();

        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));

        Speciality foundSpecialty = service.findById(1L);

        assertThat(foundSpecialty).isNotNull();

        verify(specialtyRepository).findById(anyLong());
    }

    @Test
    void save_test() {
        when(specialtyRepository.save(any(Speciality.class))).thenReturn(speciality);

        Speciality savedSpecialty = service.save(speciality);

        verify(specialtyRepository).save(any(Speciality.class));

        assertThat(savedSpecialty).isNotNull();
    }

    @Test
    void testDelete() {
        service.delete(speciality);
        verify(specialtyRepository).delete(speciality);
        /* could be like this
        service.delete(any());
        verify(specialtyRepository).delete(any());
         */
    }

    @DisplayName("deleteById Tests")
    @Nested
    class deleteById{

        @DisplayName("deleteById should verify")
        @Test
        void deleteById() {
            service.deleteById(1L);

            verify(specialtyRepository).deleteById(1L);
        }

        @DisplayName("deleteById should invoke 2 times")
        @Test
        void deleteByIdInvokeTwoTimes() {
            service.deleteById(1L);
            service.deleteById(1L);

            verify(specialtyRepository, times(2)).deleteById(1L);
        }

        @DisplayName("deleteById should at least once")
        @Test
        void deleteByIdInvokeAtLeastOnce() {
            service.deleteById(1L);
            service.deleteById(1L);

            verify(specialtyRepository, atLeastOnce()).deleteById(1L);
        }

        @DisplayName("deleteById should invoke at most 5")
        @Test
        void deleteByIdInvokeAtMost() {
            service.deleteById(1L);
            service.deleteById(1L);

            verify(specialtyRepository, atMost(5)).deleteById(1L);
        }

        @DisplayName("deleteById should invoke never")
        @Test
        void deleteByIdInvokeNever() {
            service.deleteById(1L);
            service.deleteById(1L);

            verify(specialtyRepository, atLeastOnce()).deleteById(1L);

            verify(specialtyRepository, never()).deleteById(5L);
        }
    }
}