package com.example.testassessment.repository.mock;

import com.example.testassessment.repository.AdPlace;
import com.example.testassessment.repository.AdPlaceRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AdPlaceRepositoryMock implements AdPlaceRepository {
    private List<AdPlace> adPlace = Arrays.asList(MockConstants.ANIM_AD_PLACE, MockConstants.VIDEO_AD_PLACE);

    @Override
    public Optional<AdPlace> findById(String id) {
        return adPlace.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }
}
