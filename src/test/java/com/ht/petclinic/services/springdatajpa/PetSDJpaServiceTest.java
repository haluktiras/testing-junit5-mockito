package com.ht.petclinic.services.springdatajpa;

import com.ht.petclinic.model.Pet;
import com.ht.petclinic.repositories.PetRepository;
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
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService service;

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet();
    }

    @DisplayName("Pet Service findAll() method test")
    @Test
    void findAll_test() {
        Set<Pet> petSet = new HashSet<>();
        petSet.add(pet);

        when(petRepository.findAll()).thenReturn(petSet);

        Set<Pet> returnedPetSet = service.findAll();

        assertThat(returnedPetSet).isNotNull();
        assertThat(returnedPetSet).hasSize(1);

        verify(petRepository).findAll();
    }

    @DisplayName("Pet Service findById() method test")
    @Test
    void findById_test() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));

        Pet foundPet = service.findById(anyLong());

        assertThat(foundPet).isNotNull();

        verify(petRepository).findById(anyLong());
    }

    @DisplayName("Pet Service save() method test")
    @Test
    void save_test() {
        when(petRepository.save(any(Pet.class))).thenReturn(pet);

        Pet savedPet = service.save(new Pet());

        verify(petRepository).save(any(Pet.class));

        assertThat(savedPet).isNotNull();
    }

    @DisplayName("Pet Service delete() method test")
    @Test
    void delete_test() {
        service.delete(pet);

        verify(petRepository).delete(pet);
    }

    @DisplayName("Pet Service deleteById() method test")
    @Test
    void deleteById_test() {
        service.deleteById(anyLong());

        verify(petRepository).deleteById(anyLong());
    }
}