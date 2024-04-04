package com.example.SpringBoot;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class TestClass {
@Id
@SequenceGenerator(
        name = "Test_Sequence",
        sequenceName="Test_sequence",
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator="Test_Sequence"
)

private Long id;
    private String name;
    private String email;
    private LocalDate DateOfBirth;
@Transient
    public Integer getAge() {
        return Period.between(this.DateOfBirth,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
    public Long getId() {
    return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

public TestClass(){

}

    public TestClass(Long id, String name, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        DateOfBirth = dateOfBirth;
    }

    public TestClass(String name, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        DateOfBirth = dateOfBirth;
    }


}
