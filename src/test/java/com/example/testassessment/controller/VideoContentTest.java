package com.example.testassessment.controller;

import com.example.testassessment.controller.content.VideoContent;
import com.example.testassessment.repository.mock.MockConstants;
import com.example.testassessment.util.AdSize;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;


public class VideoContentTest {
    private ApplicationContext context;
    private AdController adController;


    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("/application-context.xml");
        adController = (AdController) context.getBean("adController");
    }

    @Test
    public void videoTest() {
        String request = "{\"adPlaceId\":\"" + MockConstants.VIDEO_AD_PLACE_ID + "\",\"h\":280,\"w\":325}";
        String response = adController.serveAd(request);
        assertEquals("{\"url\":\"http://cdn303.example.com/video/codec/mp4/240-320.mp4\",\"type\":\"video\"}", response);
    }

    @Test
    public void videoTestSmall() {
        String request = "{\"adPlaceId\":\"" + MockConstants.VIDEO_AD_PLACE_ID + "\",\"h\":250,\"w\":300}";
        String response = adController.serveAd(request);
        assertEquals("{}", response);
    }

    @Test
    public void videoTestBig() {
        String request = "{\"adPlaceId\":\"" + MockConstants.VIDEO_AD_PLACE_ID + "\",\"h\":2500,\"w\":3000}";
        String response = adController.serveAd(request);
        assertEquals("{\"url\":\"http://cdn303.example.com/video/codec/mp4/900-1440.mp4\",\"type\":\"video\"}", response);
    }

    @Test
    public void videoTestIrregular() {
        String request = "{\"adPlaceId\":\"" + MockConstants.VIDEO_AD_PLACE_ID + "\",\"h\":2500,\"w\":10}";
        String response = adController.serveAd(request);
        assertEquals("{}", response);
    }

    @Test
    public void videoTesDynamic() {
        String request = "{\"adPlaceId\":\"" + MockConstants.VIDEO_AD_PLACE_ID + "\",\"h\":250,\"w\":300}";
        String response = adController.serveAd(request);
        assertEquals("{}", response);

        VideoContent videoContent = (VideoContent)context.getBean("videoContent");

        videoContent.addGeneratedSize(new AdSize(40, 40));
        response = adController.serveAd(request);
        assertEquals("{\"url\":\"http://cdn303.example.com/video/codec/mp4/40-40.mp4\",\"type\":\"video\"}", response);

        videoContent.removeGeneratedSize(new AdSize(40, 40));
        response = adController.serveAd(request);
        assertEquals("{}", response);
    }
}