package com.example.testassessment.weirdcode;

import lombok.Data;

@Data
public class App {
    private String id;
    private boolean banned;
    private Integer minH;
    private Integer minW;
    private Integer maxH;
    private Integer maxW;

    public boolean isSmallerThanMinimum(int h, int w) {
        return minH != null && minW != null
                && minH > h && minW > w;
    }

    public boolean isBiggerThanMaximum(int h, int w) {
        return maxH != null && maxW != null
                && maxH < h && maxW < w;
    }

}
