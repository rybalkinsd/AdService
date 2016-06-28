package com.example.testassessment.util;

import lombok.Getter;

import java.util.Comparator;


public class AdSize {
    @Getter
    private final int height;
    @Getter
    private final int width;

    public AdSize(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public static final Comparator<AdSize> BY_SIZE_COMPARATOR = (o1, o2) -> o1.getSize() - o2.getSize();
    public static final AdSize ZERO_SIZE_AD = new AdSize(0, 0);

    private int getSize() {
        return height * width;
    }


    public boolean isLessThan(AdSize size) {
        return height < size.height || width < size.width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdSize)) return false;

        AdSize adSize = (AdSize) o;

        if (height != adSize.height) return false;
        if (width != adSize.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
        return result;
    }
}
