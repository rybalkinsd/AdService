package com.example.testassessment.util;

import lombok.Data;

import java.util.Comparator;


@Data
public class AdSize {
    private final int height;
    private final int width;

    public static final Comparator<AdSize> BY_SIZE_COMPARATOR = (o1, o2) -> o1.getSize() - o2.getSize();
    public static final AdSize ZERO_SIZE_AD = new AdSize(0, 0);

    private int getSize() {
        return height * width;
    }


    public boolean isLessThan(AdSize size) {
        return height < size.height || width < size.width;
    }
}
