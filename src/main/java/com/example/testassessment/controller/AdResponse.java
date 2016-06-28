package com.example.testassessment.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.net.URL;

@Data
class AdResponse {
    public static final AdResponse EmptyAdResponse = new AdResponse(null, null);

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final URL url;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String type;
}
