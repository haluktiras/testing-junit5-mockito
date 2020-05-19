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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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
        //given forEach
        speciality = new Speciality();
    }

    @Test
    void findAll_test() {
        //given
        Set<Speciality> specialtySet = new HashSet<>();
        specialtySet.add(speciality);
        given(specialtyRepository.findAll()).willReturn(specialtySet);

        //when
        Set<Speciality> foundSpecialitySet = service.findAll();

        //then
        then(specialtyRepository).should().findAll();
        assertThat(foundSpecialitySet).isNotNull();
        assertThat(foundSpecialitySet).hasSize(1);
    }

    @Test
    void testDeleteByObject() {
        //given
        Speciality speciality = new Speciality();

        //when
        service.delete(speciality);

        //then
        then(specialtyRepository).should().delete(any(Speciality.class));
    }

    @Test
    void findByIdTest() {
        //given
        Speciality specialty = new Speciality();
        given(specialtyRepository.findById(anyLong())).willReturn(Optional.of(specialty));

        //when
        Speciality foundSpecialty = service.findById(1L);

        //then
        assertThat(foundSpecialty).isNotNull();
        then(specialtyRepository).should().findById(1L);
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void save_test() {
        //given
        given(specialtyRepository.save(any(Speciality.class))).willReturn(speciality);

        //when
        Speciality savedSpecialty = service.save(speciality);

        //then
        then(specialtyRepository).should().save(any(Speciality.class));
        assertThat(savedSpecialty).isNotNull();
    }

    @Test
    void testDelete() {
        //given
        //when
        service.delete(speciality);

        //then
        then(specialtyRepository).should().delete(speciality);

        /* could be like this
        service.delete(any());                           <---- any()
        verify(specialtyRepository).delete(any());       <---- any() and verify instead of then()
         */
    }

    @DisplayName("deleteById Tests")
    @Nested
    class deleteById {

        @DisplayName("deleteById should verify")
        @Test
        void deleteById() {
            //given
            //when
            service.deleteById(1L);

            //then
            then(specialtyRepository).should().deleteById(1L);
        }

        @DisplayName("deleteById should invoke 2 times")
        @Test
        void deleteByIdInvokeTwoTimes() {
            //given
            //when
            service.deleteById(1L);
            service.deleteById(1L);

            //then
            then(specialtyRepository).should(times(2)).deleteById(1L);
        }

        @DisplayName("deleteById should at least once")
        @Test
        void deleteByIdInvokeAtLeastOnce() {
            //given
            //when
            service.deleteById(1L);
            service.deleteById(1L);

            //then
            then(specialtyRepository).should(atLeastOnce()).deleteById(1L);
        }

        @DisplayName("deleteById should invoke at most 5")
        @Test
        void deleteByIdInvokeAtMost() {
            //given
            //when
            service.deleteById(1L);
            service.deleteById(1L);

            //then
            then(specialtyRepository).should(atMost(5)).deleteById(1L);
        }

        @DisplayName("deleteById should invoke never")
        @Test
        void deleteByIdInvokeNever() {
            //given
            //when
            service.deleteById(1L);
            service.deleteById(1L);

            //then
            then(specialtyRepository).should(atLeastOnce()).deleteById(1L);
            then(specialtyRepository).should(never()).deleteById(5L);
        }
    }
}