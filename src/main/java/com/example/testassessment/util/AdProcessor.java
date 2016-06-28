package com.example.testassessment.util;

import com.example.testassessment.weirdcode.AdPlace;
import com.example.testassessment.weirdcode.AdPlaceRepository;
import com.example.testassessment.weirdcode.App;
import com.example.testassessment.weirdcode.AppRepository;

public class AdProcessor {

    private AdPlaceRepository adPlaceRepository;
    private AppRepository appRepository;

    public AdResponse process(AdRequest request) {
        AdPlace adPlace = adPlaceRepository.findById(request.getAdPlaceId());

        App app = appRepository.findById(adPlace.getAppId());
        if (app.isBanned()) {
            return AdResponse.EmptyAdResponse;
        }

        if (app.isSmallerThanMinimum(request.getH(), request.getW())) {
            return AdResponse.EmptyAdResponse;
        }

        if (app.isBiggerThanMaximum(request.getH(), request.getW())) {
            // todo upd size
        }
    }

    private boolean isSmallerThenMinimumAllowed(App app, )
}
