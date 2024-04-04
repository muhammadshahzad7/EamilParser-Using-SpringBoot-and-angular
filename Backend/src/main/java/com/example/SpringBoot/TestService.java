package com.example.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void addNewTest(TestClass test1) {
        // Check if a test with the same email exists
        if (testRepository.existsByEmail(test1.getEmail())) {
            throw new IllegalStateException("Email is already taken");
        }

        // If email is unique, save the test
        testRepository.save(test1);
    }

    public List<TestClass> hello() {
        return testRepository.findAll();
    }

    public void deleteTest(Long test) {
    }
}
