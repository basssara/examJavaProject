package com.example.java_exam_project.controller;

import com.example.java_exam_project.entity.Person;
import com.example.java_exam_project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/person")
    public ResponseEntity<Long> saveEmployee(Person person) {
        Person newPerson = (Person) personRepository.save(person);
        return new ResponseEntity<Long>(newPerson.getPersonId(), HttpStatus.OK);
    }

    @PutMapping("/person/{id}")
    ResponseEntity<Long> updatePerson(@RequestBody Person newPerson, @PathVariable Long persontId) {
        return personRepository.findById(personId).map(person -> {
            person.setPersonId(newPersonerson.getPersonId());
            person.setName(newPersonerson.getName());
            person.setAge(newPersonerson.getAge());
            person.setAverageMark(newPerson.getAverageMark());
            person.setAbsenteeism(newPerson.getAbsenteeism());
            personRepository.save(person);
            return new ResponseEntity<Long>(person.getPersonId(), HttpStatus.OK);
        }).orElseGet(() -> {
            newPerson.setPersonId(personId);
            personRepository.save(newPerson);
            return new ResponseEntity<Long>(newPerson.getPersonId(), HttpStatus.OK);
        });
    }

    @DeleteMapping("/person/{id}")
    ResponseEntity<Long> deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return new ResponseEntity<Person>(personRepository.findById(id).get(), HttpStatus.OK);
    }

    @RequestMapping("/person")
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> list = (List<Person>) personRepository.findAll();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }
}
