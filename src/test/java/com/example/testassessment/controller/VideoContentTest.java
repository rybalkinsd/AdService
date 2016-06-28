package com.example.testassessment.controller;

import com.example.testassessment.controller.content.Contents;
import com.example.testassessment.repository.AdPlace;
import com.example.testassessment.repository.App;
import com.example.testassessment.util.AdSize;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class VideoContentTest {
    private static final String AD_PLACE_ID = "1f855d85-6b3b-4113-af6b-c87b1b39e185";
    private static final String APP_ID = "2e95de7a-12c3-421f-b6dd-fe19623a3763";
    private static final String AD_PLACE_TYPE_VID = "video";

    private AdController adController;


    @Before
    public void setUp() throws Exception {
        AdPlace adPlace = new AdPlace();
        adPlace.setId(AD_PLACE_ID);
        adPlace.setAppId(APP_ID);
        adPlace.setType(AD_PLACE_TYPE_VID);

        App app = new App();
        app.setId(APP_ID);

        AdProcessor adProcessor = new AdProcessor();
        adProcessor.setResourceService(new AdResourceService());
        adProcessor.setAdPlaceRepository(id -> AD_PLACE_ID.equals(id) ? Optional.of(adPlace) : Optional.empty());
        adProcessor.setAppRepository(id -> APP_ID.equals(id) ? Optional.of(app) : Optional.empty());

        adController = new AdController();
        adController.setAdProcessor(adProcessor);
    }

    @Test
    public void videoTest() {
        String jsonRequest = "{\"adPlaceId\":\"" + AD_PLACE_ID + "\",\"h\":280,\"w\":325}";
        String response = adController.serveAd(jsonRequest);
        assertEquals("{\"url\":\"http://cdn303.example.com/video/codec/mp4/240-320.mp4\",\"type\":\"video\"}", response);
    }

    @Test
    public void videoTestSmall() {
        String jsonRequest = "{\"adPlaceId\":\"" + AD_PLACE_ID + "\",\"h\":250,\"w\":300}";
        String response = adController.serveAd(jsonRequest);
        assertEquals("{}", response);
    }

    @Test
    public void videoTestBig() {
        String jsonRequest = "{\"adPlaceId\":\"" + AD_PLACE_ID + "\",\"h\":2500,\"w\":3000}";
        String response = adController.serveAd(jsonRequest);
        assertEquals("{\"url\":\"http://cdn303.example.com/video/codec/mp4/900-1440.mp4\",\"type\":\"video\"}", response);
    }

    @Test
    public void videoTestIrregular() {
        String jsonRequest = "{\"adPlaceId\":\"" + AD_PLACE_ID + "\",\"h\":2500,\"w\":10}";
        String response = adController.serveAd(jsonRequest);
        assertEquals("{}", response);
    }

    @Test
    public void videoTesDynamic() {
        String jsonRequest = "{\"adPlaceId\":\"" + AD_PLACE_ID + "\",\"h\":250,\"w\":300}";
        String response = adController.serveAd(jsonRequest);
        assertEquals("{}", response);

        Contents.VIDEO.addGeneratedSize(new AdSize(40, 40));
        response = adController.serveAd(jsonRequest);
        assertEquals("{\"url\":\"http://cdn303.example.com/video/codec/mp4/40-40.mp4\",\"type\":\"video\"}", response);

        Contents.VIDEO.removeGeneratedSize(new AdSize(40, 40));
        response = adController.serveAd(jsonRequest);
        assertEquals("{}", response);
    }
}