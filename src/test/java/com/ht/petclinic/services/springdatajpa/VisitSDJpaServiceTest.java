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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    Visit visit;

    @BeforeEach
    void setUp() {
        visit = new Visit();
    }

    @DisplayName("Visit Service findAll() method test")
    @Test
    void findAll_test() {
        Set<Visit> visitSet = new HashSet<>();
        visitSet.add(visit);

        when(visitRepository.findAll()).thenReturn(visitSet);

        Set<Visit> returnedVisitSet = service.findAll();

        assertThat(returnedVisitSet).isNotNull();
        assertThat(returnedVisitSet).hasSize(1);

        verify(visitRepository).findAll();
    }

    @DisplayName("Visit Service findById() method test")
    @Test
    void findById_test() {
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(anyLong());

        assertThat(foundVisit).isNotNull();

        verify(visitRepository).findById(anyLong());
    }

    @DisplayName("Visit Service save() method test")
    @Test
    void save_test() {
        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(new Visit());

        verify(visitRepository).save(any(Visit.class));

        assertThat(savedVisit).isNotNull();
    }

    @DisplayName("Visit Service delete() method test")
    @Test
    void delete_test() {
        service.delete(visit);

        verify(visitRepository).delete(visit);
    }

    @DisplayName("Visit Service deleteById() method test")
    @Test
    void deleteById_test() {
        service.deleteById(anyLong());

        verify(visitRepository).deleteById(anyLong());
    }
}