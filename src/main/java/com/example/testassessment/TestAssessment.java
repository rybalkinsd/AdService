package com.example.testassessment;

import com.example.testassessment.util.AdRequest;
import com.example.testassessment.weirdcode.Facade;
import com.example.testassessment.weirdcode.util.TestAssessmentConstants;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class TestAssessment {

    public static void main(String... args) throws IOException {
        String jsonRequest = args.length == 1 ?
                args[0] :
                "{\"adPlaceId\":\""+ TestAssessmentConstants.AD_PLACE_ID +"\",\"h\":150,\"w\":150}";
        ObjectMapper mapper = new ObjectMapper();

        AdRequest request = mapper.readValue(jsonRequest, AdRequest.class);
        System.out.println(request);
        Facade facade = TestAssessmentConstants.constructFacade();
        String jsonResponse = facade.serveAd(jsonRequest);

        System.out.printf(jsonResponse);
    }

}
