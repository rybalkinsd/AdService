package com.example.testassessment.controller;

import com.example.testassessment.controller.content.Content;
import com.example.testassessment.util.AdSize;
import lombok.Setter;

import java.net.URL;
import java.util.*;

public class AdResourceService {
    @Setter
    private List<Content> contents = Collections.emptyList();

    /**
     * Generates advertisement content "on-the-fly". Generated content will fit perfect into ad space size.
     *
     * @param adType type of advertisement
     * @param size size of advertisement
     * @return Optional<URL> of file which should be displayed on client side
     */
    public Optional<URL> getResourceLocator(String adType, AdSize size) {
        Optional<Content> content = contents.stream()
                .filter(c -> c.getType().equals(adType))
                .findFirst();

        return content.map(c -> c.resizeTo(size).orElse(null));
    }
    
}
