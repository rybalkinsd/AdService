package com.example.testassessment.weirdcode;

import org.junit.Assert;
import org.junit.Test;

public class BannerImageServiceTest {

    BannerImageService bannerImageService = new BannerImageService();

    @Test
    public void test() throws Exception {
        Assert.assertTrue(bannerImageService.bannerImage("image", 100, 100).contains("png"));
        Assert.assertTrue(bannerImageService.bannerImage("animation", 100, 100).contains("gif"));
        Assert.assertTrue(bannerImageService.bannerImage("video", 100, 100).contains("mp4"));
    }
}
