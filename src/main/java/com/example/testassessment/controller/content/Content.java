package com.example.testassessment.controller.content;

import com.example.testassessment.util.AdSize;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Content {
    private static final Logger log = LoggerFactory.getLogger(Content.class);

    @Getter
    private String type;
    @Getter
    private String urlFormat;

    public Content(String type, String urlFormat) {
        this.type = type;
        this.urlFormat = urlFormat;
    }

    public Optional<URL> resizeTo(AdSize size) {
        try {
            return Optional.of(new URL(String.format(urlFormat, size.getHeight(), size.getWidth())));
        } catch (MalformedURLException e) {
            log.warn("Url formatting failed {}.", urlFormat);
            return Optional.empty();
        }
    }
}
