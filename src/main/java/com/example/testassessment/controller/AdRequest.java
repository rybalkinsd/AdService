package com.example.testassessment.controller;

import com.example.testassessment.util.AdSize;
import lombok.Data;

@Data
public class AdRequest {
    private String adPlaceId;
    private int h;
    private int w;

    public AdSize getSize() {
        return new AdSize(h, w);
    }
}
