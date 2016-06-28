package com.example.testassessment.repository;

import com.example.testassessment.util.AdSize;
import lombok.Data;

@Data
public class App {
    private String id;
    private boolean banned;
    private AdSize adMinSize = AdSize.ZERO_SIZE_AD;
    private AdSize adMaxSize;
}
