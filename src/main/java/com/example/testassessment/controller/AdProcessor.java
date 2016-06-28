package com.example.testassessment.controller;

import com.example.testassessment.data.AdPlace;
import com.example.testassessment.data.AdPlaceRepository;
import com.example.testassessment.data.App;
import com.example.testassessment.data.AppRepository;
import com.example.testassessment.util.AdSize;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Optional;


class AdProcessor {
    private static final Logger log = LoggerFactory.getLogger(AdProcessor.class);

    @Setter
    private AdPlaceRepository adPlaceRepository;
    @Setter
    private AppRepository appRepository;
    @Setter
    private AdResourceService resourceService;


    AdResponse process(final AdRequest request) {
        Optional<AdPlace> oAdPlace = adPlaceRepository.findById(request.getAdPlaceId());
        if (!oAdPlace.isPresent()) {
            log.info("No {} in adPlaceRepository.", request.getAdPlaceId());
            return AdResponse.EmptyAdResponse;
        }

        AdPlace adPlace = oAdPlace.get();
        Optional<App> oApp = appRepository.findById(adPlace.getAppId());
        if (!oApp.isPresent()) {
            log.info("No {} in appRepository.", adPlace.getAppId());
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

        if (app.getAdMaxSize().isLessThan(requestedAdSize)) {
            requestedAdSize = app.getAdMaxSize();
        }

        Optional<URL> resource = resourceService.getResourceLocator(adPlace.getType(), requestedAdSize);

        if (!resource.isPresent()) {
            return AdResponse.EmptyAdResponse;
        }

        return new AdResponse(resource.get(), adPlace.getType());
    }

}
