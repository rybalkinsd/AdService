package com.example.testassessment.controller.content;

import com.example.testassessment.util.AdSize;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VideoContent extends Content {
    private List<AdSize> generatedSizes = new ArrayList<>();

    public VideoContent(String type, String urlFormat) {
        super(type, urlFormat);
    }

    @Override
    public Optional<URL> resizeTo(AdSize size) {
        Optional<AdSize> closestSize = generatedSizes.stream()
                .filter(s -> !size.isLessThan(s))
                .max(AdSize.BY_SIZE_COMPARATOR);

        return closestSize.map(s -> super.resizeTo(s).orElse(null));
    }

    public boolean addGeneratedSize(AdSize size) {
        return size != null
                && generatedSizes.add(size);
    }

    public boolean removeGeneratedSize(AdSize size) {
        return size != null
                && generatedSizes.remove(size);
    }
}
