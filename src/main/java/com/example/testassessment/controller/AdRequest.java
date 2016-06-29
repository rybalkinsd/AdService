package com.example.testassessment.controller;

import com.example.testassessment.util.AdSize;
import lombok.Data;

@Data
class AdRequest {
    private String adPlaceId;
    private int h;
    private int w;

    AdSize getSize() {
        return new AdSize(h, w);
    }
}
