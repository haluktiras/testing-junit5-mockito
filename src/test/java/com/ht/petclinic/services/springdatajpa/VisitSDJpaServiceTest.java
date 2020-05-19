package com.ht.petclinic.services.springdatajpa;

import com.ht.petclinic.model.Visit;
import com.ht.petclinic.repositories.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    Visit visit;

    @BeforeEach
    void setUp() {
        //given forEach
        visit = new Visit();
    }

    @DisplayName("Visit Service findAll() method test")
    @Test
    void findAll_test() {
        //given
        Set<Visit> visitSet = new HashSet<>();
        visitSet.add(visit);
        given(visitRepository.findAll()).willReturn(visitSet);

        //when
        Set<Visit> returnedVisitSet = service.findAll();

        //then
        then(visitRepository).should().findAll();
        assertThat(returnedVisitSet).isNotNull();
        assertThat(returnedVisitSet).hasSize(1);
    }

    @DisplayName("Visit Service findById() method test")
    @Test
    void findById_test() {
        //given
        given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));

        //when
        Visit foundVisit = service.findById(anyLong());

        //then
        then(visitRepository).should().findById(anyLong());
        assertThat(foundVisit).isNotNull();
    }

    @DisplayName("Visit Service save() method test")
    @Test
    void save_test() {
        //given
        given(visitRepository.save(any(Visit.class))).willReturn(visit);

        //when
        Visit savedVisit = service.save(new Visit());

        //then
        then(visitRepository).should().save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
    }

    @DisplayName("Visit Service delete() method test")
    @Test
    void delete_test() {
        //given

        //when
        service.delete(visit);

        //then
        then(visitRepository).should().delete(visit);
    }

    @DisplayName("Visit Service deleteById() method test")
    @Test
    void deleteById_test() {
        //given

        //when
        service.deleteById(anyLong());

        //then
        then(visitRepository).should().deleteById(anyLong());
    }
}