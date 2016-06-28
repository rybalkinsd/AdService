package com.example.testassessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AdController {
    private static final Logger log = LoggerFactory.getLogger(AdController.class);

    @Setter
    private AdProcessor adProcessor;

    public String serveAd(String request) {
        ObjectMapper mapper = new ObjectMapper();

        AdRequest adRequest;
        try {
            adRequest = mapper.readValue(request, AdRequest.class);
        } catch (IOException e) {
            log.info("({}) -> ({})", request);
            return "";
        }

        AdResponse adResponse = adProcessor.process(adRequest);

        try {
            String response = mapper.writeValueAsString(adResponse);
            log.info("({}) -> ({})", request, response);
            return response;
        } catch (IOException e) {
            log.info("({}) -> ({})", request);
            return "";
        }
    }
}
