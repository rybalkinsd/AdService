package com.example.testassessment.weirdcode;

import com.example.testassessment.controller.AdResourceService;
import com.example.testassessment.util.AdSize;
import org.junit.Assert;
import org.junit.Test;

public class AdResourceServiceTest {
    private AdResourceService adResourceService = new AdResourceService();

    @Test
    public void test() throws Exception {
        Assert.assertTrue(adResourceService.getResourceLocator("image", new AdSize(100, 100)).get().getPath().contains("png"));
        Assert.assertTrue(adResourceService.getResourceLocator("animation", new AdSize(100, 100)).get().getPath().contains("gif"));
        Assert.assertFalse(adResourceService.getResourceLocator("video", new AdSize(100, 100)).isPresent());
        Assert.assertTrue(adResourceService.getResourceLocator("video", new AdSize(330, 380)).get().getPath().contains("mp4"));

    }
}
