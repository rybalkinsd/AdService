package com.example.testassessment.controller;

import com.example.testassessment.controller.content.Content;
import com.example.testassessment.util.AdSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class AdResourceService {
    private static final Logger log = LoggerFactory.getLogger(AdResourceService.class);
    private static final Set<Content> urlFormats = new HashSet<Content>() {{
        add(new Content("image", "http://cdn101.example.com/img/%dx%d.png"));
        add(new Content("animation", "http://cdn202.example.com/img/%dx%d.gif"));
        add(new Content("video", "http://cdn303.example.com/video/codec/mp4/%d-%d.mp4"));
    }};

    /**
     * Generates advertisement content "on-the-fly". Generated content will fit perfect into ad space size.
     *
     * @param adType type of advertisement
     * @param size size of advertisement
     * @return URL of file which should be displayed on client side
     */
    public Optional<URL> getResourceLocator(String adType, AdSize size) {
        String urlFormat = urlFormats.get(adType);
        if (urlFormat == null) {
            log.info("Unknown adType {}.", adType);
            return Optional.empty();
        }

        try {
            return Optional.of(new URL(String.format(urlFormat, size.getHigh(), size.getWidth())));
        } catch (MalformedURLException e) {
            log.warn("Url formatting failed {}.", urlFormat);
            return Optional.empty();
        }
    }
    
}
