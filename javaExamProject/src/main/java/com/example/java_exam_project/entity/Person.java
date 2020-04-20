package com.example.java_exam_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long persontId;

    private String name;

    private Integer age;

    private Double averageMark; //From all subjects

    private Integer absenteeism; // The number of absence lectures

    public Person(Long persontId, String name, Integer age, Double averageMark, Integer absenteeism) {
        this.persontId = personId;
        this.name = name;
        this.age = age;
        this.averageMark = averageMark;
        this.absenteeism = absenteeism;
    }

    public Person() {
    }

    public Long getPersonId() {
        return persontId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    public Integer getAbsenteeism() {
        return age;
    }

    public void setAbsenteeism(Integer absenteeism) {
        this.absenteeism = absenteeism;
    }
}
