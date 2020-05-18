package com.ht.petclinic.services.springdatajpa;

import com.ht.petclinic.model.Speciality;
import com.ht.petclinic.model.Vet;
import com.ht.petclinic.repositories.VetRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;

    Vet vet;

    @BeforeEach
    void setUp() {
        Set<Speciality> specialitySet = new HashSet<>();
        vet = new Vet(1L, "Haluk", "tiras", specialitySet);
    }

    @DisplayName("findAll() - should return the all objects")
    @Test
    void findAll_test() {
        Set<Vet> vetSet = new HashSet<>();
        vetSet.add(vet);

        when(vetRepository.findAll()).thenReturn(vetSet);

        Set<Vet> returnedVisitSet = service.findAll();

        assertThat(returnedVisitSet).isNotNull();
        assertThat(returnedVisitSet).hasSize(1);

        verify(vetRepository).findAll();
    }

    @DisplayName("findById() - should find the given id's object")
    @Test
    void findbyId_test() {
        when(vetRepository.findById(1L)).thenReturn(Optional.of(vet));

        Vet foundVet = service.findById(1L);

        assertThat(foundVet).isNotNull();

        verify(vetRepository).findById(1L);
    }

    @DisplayName("save() - should save the given object")
    @Test
    void save_test() {
        when(vetRepository.save(any(Vet.class))).thenReturn(vet);

        Vet savedVet = service.save(vet);

        verify(vetRepository).save(any(Vet.class));

        assertThat(savedVet).isNotNull();
    }

    @DisplayName("delete() - should delete the given object")
    @Test
    void delete_test() {
        service.delete(vet);
        verify(vetRepository).delete(any(Vet.class));
    }

    @DisplayName("deleteById() should delete by given id")
    @Test
    void deleteById_test() {
        service.deleteById(1L);
        verify(vetRepository).deleteById(1L);
        verify(vetRepository, atLeastOnce()).deleteById(1L);
    }
}