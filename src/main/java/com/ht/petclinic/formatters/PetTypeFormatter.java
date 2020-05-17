package com.ht.petclinic.formatters;

import com.ht.petclinic.model.PetType;
import com.ht.petclinic.services.PetTypeService;
import com.ht.petclinic.fauxspring.Formatter;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;


public class PetTypeFormatter implements Formatter {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
