package com.example.testassessment.repository.mock;

import com.example.testassessment.repository.App;
import com.example.testassessment.repository.AppRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AppRepositoryMock implements AppRepository {
    private List<App> app = Arrays.asList(MockConstants.BOUNDED_APP, MockConstants.UNBOUNDED_APP);

    @Override
    public Optional<App> findById(String id) {
        return app.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }
}
