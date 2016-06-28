package com.example.testassessment.util;

import lombok.Data;

/**
 * Created by s.rybalkin on 28.06.2016.
 */
@Data
public class AdSize {
    private final int high;
    private final int width;

    public boolean isLessThan(AdSize size) {
        return high < size.high || width < size.width;
    }

    public boolean isValid() {
        return high > 0 && width > 0;
    }
}
