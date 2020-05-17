package com.ht.petclinic.controllers;

import com.ht.petclinic.services.VetService;
import com.ht.petclinic.fauxspring.Model;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
