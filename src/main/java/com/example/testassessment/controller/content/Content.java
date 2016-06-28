package com.example.testassessment.controller.content;

import com.example.testassessment.util.AdSize;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.net.MalformedURLException;
import java.net.URL;

@EqualsAndHashCode
public class Content {
    @Getter
    private String type;
    @Getter
    private String urlFormat;

    public Content(String type, String urlFormat) {
        this.type = type;
        this.urlFormat = urlFormat;
    }

    public URL resizeTo(AdSize size) throws MalformedURLException {
        return new URL(String.format(urlFormat, size.getHigh(), size.getWidth()));
    }
}
