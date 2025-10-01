package com.optimagrowth.license.service;

import com.optimagrowth.license.data.PersonRepository;
import com.optimagrowth.license.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public String createPerson(Person person) {
        personRepository.save(person);
        return person.toString();
    }

    public String deletePerson(long personId) {
        personRepository.deleteById(personId);
        return "person " + personId + " deleted";
    }

    public List<Person> list() {
        return personRepository.findAll();
    }

    public Person getPerson(long personId) {
        return personRepository.getOne(personId);
    }
}
