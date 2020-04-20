package com.example.java_exam_project.repository;


import com.example.java_exam_project.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
