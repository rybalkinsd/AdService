package com.example.testassessment.util.controller;

import com.example.testassessment.util.AdRequest;
import com.example.testassessment.util.interceprots.RequestInterceptor;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class AdController {

    private List<RequestInterceptor> interceptors;



    public String serveAd(String request) {
        ObjectMapper mapper = new ObjectMapper();

        AdRequest adRequest = null;
        try {
            adRequest = mapper.readValue(request, AdRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final AdRequest finalAdRequest = adRequest;
        if (interceptors.stream().anyMatch(x -> !x.handle(finalAdRequest))) {
            return "";
        }

        return "";
    }
}
