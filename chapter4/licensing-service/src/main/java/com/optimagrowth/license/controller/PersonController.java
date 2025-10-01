package com.optimagrowth.license.controller;

import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/{personId}",method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable("personId") long personId) {
        return ResponseEntity.ok(personService.getPerson(personId));
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @DeleteMapping(value="/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable("personId") long personId) {
        return ResponseEntity.ok(personService.deletePerson(personId));
    }
}
