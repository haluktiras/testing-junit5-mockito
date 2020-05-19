package com.ht.petclinic.services.springdatajpa;

import com.ht.petclinic.model.Owner;
import com.ht.petclinic.model.Speciality;
import com.ht.petclinic.repositories.OwnerRepository;
import com.ht.petclinic.repositories.PetRepository;
import com.ht.petclinic.repositories.PetTypeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner(1L, "haluk", "tiras");
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);

        Owner foundOwner = service.findByLastName("tiras");

        assertThat(foundOwner).isNotNull();

        verify(ownerRepository).findByLastName(anyString());
    }

    @Test
    void findAllByLastNameLike() {
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(owner);
        ownerList.add(new Owner(2L, "Michael", "Jordan"));
        ownerList.add(new Owner(3L, "Lebron", "James"));

        when(ownerRepository.findAllByLastNameLike(anyString())).thenReturn(ownerList);

        List<Owner> foundOwnerList = service.findAllByLastNameLike("tiras");

        assertThat(foundOwnerList).isNotNull();
        assertThat(foundOwnerList).hasSize(3);

        verify(ownerRepository).findAllByLastNameLike(anyString());
    }

    @Test
    void findAll() {
        Set<Owner> ownerList = new HashSet<>();
        ownerList.add(owner);
        ownerList.add(new Owner(2L, "Michael", "Jordan"));
        ownerList.add(new Owner(3L, "Lebron", "James"));

        when(ownerRepository.findAll()).thenReturn(ownerList);

        Set<Owner> foundOwnerList = service.findAll();

        assertThat(foundOwnerList).isNotNull();
        assertThat(foundOwnerList).hasSize(3);

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner foundOwner = service.findById(1L);

        verify(ownerRepository).findById(anyLong());

        assertThat(foundOwner).isNotNull();
    }

    @Test
    void save() {
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

        Owner savedOwner = service.save(owner);

        verify(ownerRepository).save(any(Owner.class));

        Assertions.assertThat(savedOwner).isNotNull();
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository).delete(owner);
    }

    @Test
    void deleteById() {
        service.deleteById(anyLong());

        verify(ownerRepository).deleteById(anyLong());
    }
}