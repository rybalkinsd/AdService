package com.example.testassessment.controller.interceprots;

import com.example.testassessment.controller.AdRequest;

public class ValidateParamsInterceptor implements RequestInterceptor {

    @Override
    public boolean handle(AdRequest request) {
        return request.getSize().getHigh() > 0 && request.getSize().getWidth() > 0;
    }
}
