package com.rpaixao.question3.controller;

import com.rpaixao.question3.model.Person;
import com.rpaixao.question3.model.PersonRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PersonController {

    private PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("")
    public String persons(Model model){
        model.addAttribute("PersonsList", personRepo.findAll());
        return "/persons/index.html";
    }

    @GetMapping("/rh/persons/new")
    public String newPerson(Model model) {

        model.addAttribute("person", new Person());
        return "rh/persons/form";
    }

    @GetMapping("/rh/persons/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        Optional<Person> personOpt = personRepo.findById(id);
        if (!personOpt.isPresent()) {
            throw new IllegalArgumentException("invalid Person.");
        }
        model.addAttribute("person", personOpt.get());
        return "person/form";
    }

    @PostMapping("/person/save")
    public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "persons/form";
        }

        personRepo.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        Optional<Person> personOpt = personRepo.findById(id);
        if (personOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid Person.");
        }

        personRepo.delete(personOpt.get());
        return "redirect:/persons";
    }


}
