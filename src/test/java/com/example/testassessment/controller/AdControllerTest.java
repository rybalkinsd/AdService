package com.example.testassessment.controller;

import com.example.testassessment.repository.mock.MockConstants;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;


public class AdControllerTest {
    private AdController adController;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
        adController = (AdController) context.getBean("adController");
    }

    @Test
    public void legacyTest() {
        String request = "{\"adPlaceId\":\"" + MockConstants.ANIM_AD_PLACE_ID + "\",\"h\":150,\"w\":150}";
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
        String request = "{\"adPlaceId\":\"" + MockConstants.ANIM_AD_PLACE_ID + "\",\"h\":150,\"w\":99}";
        String response = adController.serveAd(request);
        assertEquals("{}", response);
    }

}