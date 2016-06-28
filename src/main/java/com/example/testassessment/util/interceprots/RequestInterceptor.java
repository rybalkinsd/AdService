package com.example.testassessment.util.interceprots;

import com.example.testassessment.util.AdRequest;

public interface RequestInterceptor {

    boolean handle(AdRequest request);
}
