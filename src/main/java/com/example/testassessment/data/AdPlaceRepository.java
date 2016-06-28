package com.example.testassessment.data;

import java.util.Optional;

public interface AdPlaceRepository {

    /**
     * @return Optional.empty() if no {@link AdPlace} found
     */
    Optional<AdPlace> findById(String id);
    
}
