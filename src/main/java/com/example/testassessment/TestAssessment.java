package com.example.testassessment;

import com.example.testassessment.weirdcode.Facade;
import com.example.testassessment.weirdcode.util.TestAssessmentConstants;

public class TestAssessment {

    public static void main(String... args) {
        String jsonRequest = args.length == 1 ?
                args[0] :
                "{\"adPlaceId\":\""+ TestAssessmentConstants.AD_PLACE_ID +"\",\"h\":150,\"w\":150}";

        Facade facade = TestAssessmentConstants.constructFacade();
        String jsonResponse = facade.serveAd(jsonRequest);

        System.out.printf(jsonResponse);
    }

}
