package com.example.testassessment.repository;

import java.util.Optional;

public interface AppRepository {

    /**
     * @return Optional.empty() if no {@link App} found
     */
    Optional<App> findById(String id);
    
}
