package com.example.testassessment.data;

import com.example.testassessment.util.AdSize;
import lombok.Data;

@Data
public class App {
    private String id;
    private boolean banned;
    private AdSize adMinSize;
    private AdSize adMaxSize;
}
