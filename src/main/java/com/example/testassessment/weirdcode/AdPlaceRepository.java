package com.example.testassessment.weirdcode;

public interface AdPlaceRepository {

    /**
     * @return {@link AdPlace} or {@code null} if no {@link AdPlace} found
     */
    AdPlace findById(String id);
    
}
