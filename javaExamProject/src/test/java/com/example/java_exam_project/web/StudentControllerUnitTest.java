package com.example.java_exam_project.web;

import com.example.java_exam_project.controller.PersonController;
import com.example.java_exam_project.entity.Person;
import com.example.java_exam_project.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonRepository personRepository;

    @Test
    public void saveEmployee() throws Exception {
        Person testPerson = new Person(8L, "Dima", 19, 4.5, 65);
        mockMvc.perform(post("/person", testPerson)).andExpect(status().isOk());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void updatePerson() throws Exception {
        Person testPerson = new Person(1L, "Alexa", 29, 7.5, 15);
        mockMvc.perform(put("/person/" + testPerson.getPersonId(), testPerson)).andExpect(status().isOk());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void deletePerson() throws Exception {
        long testId = 1L;
        mockMvc.perform(put("/person/" + testId)).andExpect(status().isOk());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void getPersonsById() throws Exception {
        long testId = 2L;
        mockMvc.perform(get("/person/" + testId)).andExpect(status().isOk());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void getAllPersons() throws Exception {
        mockMvc.perform(get("/person")).andExpect(status().isOk());
        verify(personRepository, times(1)).findAll();
    }

}
