package com.example.testassessment.controller.interceprots;

import com.example.testassessment.controller.AdRequest;

public interface RequestInterceptor {

    boolean handle(AdRequest request);
}
