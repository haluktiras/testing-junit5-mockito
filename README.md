[![CircleCI](https://circleci.com/gh/haluktiras/testing-junit5-mockito.svg?style=svg)](https://app.circleci.com/pipelines/github/haluktiras/testing-junit5-mockito)

# Introduction to JUnit 5 with Mockito

This source code repository contains JUnit 5 and Mockito test examples with Maven. Spring framework was not used for learning process. Fake implementation has been added.

## Stack
* Java 11
* Maven 3.5.2
* Junit 5
* Mockito 2.23.0

## Test Coverage
|  Element                         | Class %      | Method %     |  Line %    |
|:--------------------------------:|:------------:|:------------:|:------------:|
| `com.ht.petclinic.controllers`   |  50% (3/6)   |  15% (4/26)  |   9% (9/91)  |
| `com.ht.petclinic.model`         |  44% (4/9)   |  18% (11/58) |  17% (20/112)|
| `com.ht.petclinic.services`      |  57% (4/7)   |  21% (9/42)  |  22% (22/98) |
| `com.ht.petclinic.springjpa`     | 100% (6/6)   | 100% (38/38) | 100% (76/76) |

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
        * Wrote tests for all service classes
    - Refactorings with BDD testing approach to PetTypeSDJPaServiceTest.java , SpecialitySDJpaServiceTest.java and VisitSDJpaServiceTest.java    
    
## ToDo's
* Mockito basics
    - Refactor test to BDD approaches (given/when/then)