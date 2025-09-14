package com.optimagrowth.license;

import com.optimagrowth.license.data.PersonRepository;
import com.optimagrowth.license.models.Organization;
import com.optimagrowth.license.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public <T extends Person> void savePerson(T person) {
        personRepository.save(person);
    }

    public List<Person> list() {
        return personRepository.findAll();
    }
}
