# Introduction to JUnit 5 with Mockito

This source code repository contains JUnit 5 and Mockito test examples with Maven. Spring framework was not used for learning process. Fake implementation has been added.

## Stack
* Java 11
* Maven 3.5.2
* Junit 5
* Mockito 2.23.0

## Test Coverage
|  Element                         | Class %    | Method %   |  Line %    |
|:--------------------------------:|:-----------:|:-----------:|:-----------:|
| `com.ht.petclinic.controllers`   |  50%(3/6)   |  15%(4/26)  |   9%(9/91)  |
| `com.ht.petclinic.model`         |  44%(4/9)   |  18%(11/58) |  50%(3/6)   |
| `com.ht.petclinic.services`      |  50%(3/6)   |  50%(3/6)   |  50%(3/6)   |
| `com.ht.petclinic.springjpa`     |  50%(3/6)   |  50%(3/6)   |  50%(3/6)   |

## Done's
* Unit Tests and Integration Tests has been completed with Junit5
* Junit basics and advanced tricks has been learnt.
    - Junit lifecycle
    - Junit useful annotations
    - Test Interfaces
    - Useful 3rd party libraries that works with Junit5 such as Hamcrest and AssertJ
    - Parameterized Tests with Junit
* Mockito basics
    - Creating mockito mocks with annotations and extentions
    - Injecting Mocks with mockito
    - Writing tests and verifying interactions with mockito
    - Verify Interactions with mockito mocks
    - Returining values from mockito mocks
    - Write tests for all service classes and try to increase test coverage
        * Wrote tests for VisitSDJpaService, VetSDJpaService and SpecialtySDJpaService
    
## ToDo's
* Mockito basics
    - Write Mockito Tests for Vet Service
    - Write tests for all service classes and try to increase test coverage
        *  Remainings service classes that were not wrote test yet: PetTypeSDJpaService, PetSDJpaService and OwnerSDJpaService