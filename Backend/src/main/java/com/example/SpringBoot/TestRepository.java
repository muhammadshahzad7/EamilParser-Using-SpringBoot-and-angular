package com.example.SpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends
        JpaRepository<TestClass ,Long> {
//    @Query("SELECT s FROM test_class s WHERE s.email=?1")
        // Optional<TestClass> findStudentByEmail(String email);

    boolean existsByEmail(String email);
}
