package com.example.testassessment.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.net.URL;

@Data
public class AdResponse {
    public static final AdResponse EmptyAdResponse = new AdResponse();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private URL url;
    // @todo enum
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
}
