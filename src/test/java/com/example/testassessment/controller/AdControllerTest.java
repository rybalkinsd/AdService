package com.example.testassessment.controller;

import com.example.testassessment.repository.AdPlace;
import com.example.testassessment.repository.App;
import com.example.testassessment.util.AdSize;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class AdControllerTest {
    private static final String AD_PLACE_ID = "1f855d85-6b3b-4113-af6b-c87b1b39e185";
    private static final String APP_ID = "2e95de7a-12c3-421f-b6dd-fe19623a3763";
    private static final String AD_PLACE_TYPE_ANIM = "animation";


    private AdController adController;

    @Before
    public void setUp() throws Exception {
        AdPlace adPlace = new AdPlace();
        adPlace.setId(AD_PLACE_ID);
        adPlace.setAppId(APP_ID);
        adPlace.setType(AD_PLACE_TYPE_ANIM);

        App app = new App();
        app.setId(APP_ID);
        app.setAdMinSize(new AdSize(100, 100));
        app.setAdMaxSize(new AdSize(200, 200));

        AdProcessor adProcessor = new AdProcessor();
        adProcessor.setResourceService(new AdResourceService());
        adProcessor.setAdPlaceRepository(id -> AD_PLACE_ID.equals(id) ? Optional.of(adPlace) : Optional.empty());
        adProcessor.setAppRepository(id -> app.getId().equals(id) ? Optional.of(app) : Optional.empty());

        adController = new AdController();
        adController.setAdProcessor(adProcessor);
    }

    @Test
    public void legacyTest() {
        String request = "{\"adPlaceId\":\"" + AD_PLACE_ID + "\",\"h\":150,\"w\":150}";
        String response = adController.serveAd(request);
        assertEquals("{\"url\":\"http://cdn202.example.com/img/150x150.gif\",\"type\":\"animation\"}", response);
    }

    @Test
    public void badIdRequestTest() {
        String request = "{\"adPlaceId\":\"" + 1 + "\",\"h\":150,\"w\":150}";
        String response = adController.serveAd(request);
        assertEquals("{}", response);
    }

    @Test
    public void badSizeRequestTest() {
        String request = "{\"adPlaceId\":\"" + AD_PLACE_ID + "\",\"h\":150,\"w\":99}";
        String response = adController.serveAd(request);
        assertEquals("{}", response);
    }

}