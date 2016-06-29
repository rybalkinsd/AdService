package com.example.testassessment.controller;

import com.example.testassessment.repository.AdPlace;
import com.example.testassessment.repository.AdPlaceRepository;
import com.example.testassessment.repository.App;
import com.example.testassessment.repository.AppRepository;
import com.example.testassessment.util.AdSize;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;

@Component
public class AdProcessor {
    private static final Logger log = LoggerFactory.getLogger(AdProcessor.class);

    @Autowired
    private AdPlaceRepository adPlaceRepository;
    @Autowired
    private AppRepository appRepository;
    @Autowired
    private AdResourceService resourceService;


    public AdResponse process(final AdRequest request) {
        Optional<AdPlace> oAdPlace = adPlaceRepository.findById(request.getAdPlaceId());
        if (!oAdPlace.isPresent()) {
            log.info("Not found: {} in adPlaceRepository.", request.getAdPlaceId());
            return AdResponse.EmptyAdResponse;
        }

        AdPlace adPlace = oAdPlace.get();
        Optional<App> oApp = appRepository.findById(adPlace.getAppId());
        if (!oApp.isPresent()) {
            log.info("Not found: {} in appRepository.", adPlace.getAppId());
            return AdResponse.EmptyAdResponse;
        }

        App app = oApp.get();
        if (app.isBanned()) {
            return AdResponse.EmptyAdResponse;
        }

        AdSize requestedAdSize = request.getSize();
        if (requestedAdSize.isLessThan(app.getAdMinSize())) {
            log.info("Request size {} is less than app {} adMinSize. {}", requestedAdSize, app.getId(), app.getAdMinSize());
            return AdResponse.EmptyAdResponse;
        }

        if (app.getAdMaxSize() != null && app.getAdMaxSize().isLessThan(requestedAdSize)) {
            requestedAdSize = app.getAdMaxSize();
        }

        Optional<URL> resource = resourceService.getResourceLocator(adPlace.getType(), requestedAdSize);

        if (!resource.isPresent()) {
            return AdResponse.EmptyAdResponse;
        }

        return new AdResponse(resource.get(), adPlace.getType());
    }

}
