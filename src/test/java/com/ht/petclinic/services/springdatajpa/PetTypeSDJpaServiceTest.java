package com.ht.petclinic.services.springdatajpa;

import com.ht.petclinic.model.PetType;
import com.ht.petclinic.repositories.PetTypeRepository;
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
class PetTypeSDJpaServiceTest {

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeSDJpaService service;

    PetType petType;

    @BeforeEach
    void setUp() {
        petType = new PetType();
    }

    @DisplayName("PetType Service findAll() method test")
    @Test
    void findAll_test() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeSet.add(petType);

        when(petTypeRepository.findAll()).thenReturn(petTypeSet);

        Set<PetType> returnedPetTypeSet = service.findAll();

        assertThat(returnedPetTypeSet).isNotNull();
        assertThat(returnedPetTypeSet).hasSize(1);

        verify(petTypeRepository).findAll();
    }

    @DisplayName("PetType Service findById() method test")
    @Test
    void findById_test() {
        when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(petType));

        PetType foundPetType = service.findById(anyLong());

        assertThat(foundPetType).isNotNull();

        verify(petTypeRepository).findById(anyLong());
    }

    @DisplayName("PetType Service save() method test")
    @Test
    void save_test() {
        when(petTypeRepository.save(any(PetType.class))).thenReturn(petType);

        PetType savedPetType = service.save(new PetType());

        verify(petTypeRepository).save(any(PetType.class));

        assertThat(savedPetType).isNotNull();
    }

    @DisplayName("PetType Service delete() method test")
    @Test
    void delete_test() {
        service.delete(petType);

        verify(petTypeRepository).delete(petType);
    }

    @DisplayName("PetType Service deleteById() method test")
    @Test
    void deleteById_test() {
        service.deleteById(anyLong());

        verify(petTypeRepository).deleteById(anyLong());
    }
}