package com.example.testassessment.weirdcode.util;

import com.example.testassessment.weirdcode.*;

public class TestAssessmentConstants {

    public final static String AD_PLACE_ID = "1f855d85-6b3b-4113-af6b-c87b1b39e185";
    public final static String APP_ID = "2e95de7a-12c3-421f-b6dd-fe19623a3763";
    public final static String AD_PLACE_TYPE = "animation";

    private TestAssessmentConstants() {

    }

    public static Facade constructFacade() {
        BannerImageService bannerImageService = new BannerImageService();

        AdPlace adPlace = new AdPlace();
        adPlace.setId(AD_PLACE_ID);
        adPlace.setAppId(APP_ID);
        adPlace.setType(AD_PLACE_TYPE);

        App app = new App();
        app.setId(APP_ID);
        app.setMaxH(200);
        app.setMaxW(200);
        app.setMinH(100);
        app.setMinW(100);

        UserBannerService userBannerService = new UserBannerService();
        userBannerService.setImageService(bannerImageService);
        AdPlaceRepository adPlaceRepository = id -> AD_PLACE_ID.equals(id) ? adPlace : null;
        userBannerService.setAdPlaceRepository(adPlaceRepository);
        userBannerService.setAppRepository(id -> APP_ID.equals(id) ? app : null);

        Facade facade = new Facade();
        facade.setAdPlaceRepository(adPlaceRepository);
        facade.setBannerService(userBannerService);

        return facade;
    }
}
