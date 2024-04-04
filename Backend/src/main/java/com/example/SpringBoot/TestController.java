package com.example.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<TestClass> hello() {
        return testService.hello();
    }

    @PostMapping
    public ResponseEntity<String> addNewTest(@RequestBody TestClass test1) {
        testService.addNewTest(test1);
        return ResponseEntity.ok("Test added successfully");
    }
    @DeleteMapping(path = "{id}")
    public void deleteTest(@PathVariable("id") Long TEST){
    testService.deleteTest(TEST);
    }
}
