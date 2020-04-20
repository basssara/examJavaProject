package com.example.java_exam_project.web;

import com.example.java_exam_project.entity.Person;
import org.hibernate.mapping.Any;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void saveEmployee(Person person) {
        ResponseEntity<Long> response = this.restTemplate.postForEntity("http://localhost:" + port + "/persons", person, Long.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void updatePerson(Person newPerson, Long personId) {
        this.restTemplate.put("http://localhost:" + port + "/persons/" + personId, newPerson, Long.class);
        assertThat(HttpStatus.OK, equalTo(HttpStatus.OK));
    }

    @Test
    public void deletePerson(Long personId) {
        this.restTemplate.delete("http://localhost:" + port + "/persons/" + personId, Long.class);
        assertThat(HttpStatus.OK, equalTo(HttpStatus.OK));
    }

    @Test
    public void getPersonsById(Long persontId) {
        ResponseEntity<Person> response = this.restTemplate.getForEntity("http://localhost:" + port + "/persons/" + persontId, Person.class);
        assertThat(response, equalTo(HttpStatus.OK));
    }

    @Test
    public void getAllPerson() {
        ResponseEntity<List> response = this.restTemplate.getForEntity("http://localhost:" + port + "/persons", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
