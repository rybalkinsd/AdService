package com.example.testassessment.util.interceprots;

import com.example.testassessment.util.AdRequest;

public class ValidateParamsInterceptor implements RequestInterceptor {

    @Override
    public boolean handle(AdRequest request) {
        return request.getH() > 0 && request.getW() > 0;
    }
}
