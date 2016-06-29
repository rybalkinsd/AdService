package com.example.testassessment.controller.content;

import com.example.testassessment.util.AdSize;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VideoContent extends Content {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    private List<AdSize> generatedSizes = new ArrayList<>();

    public VideoContent(String type, String urlFormat, List<AdSize> generatedSizes) {
        super(type, urlFormat);
        this.generatedSizes = generatedSizes;
    }

    @Override
    public Optional<URL> resizeTo(AdSize size) {
        Optional<AdSize> closestSize;
        try {
            readLock.lock();
            closestSize = generatedSizes.stream()
                    .filter(s -> !size.isLessThan(s))
                    .max(AdSize.BY_SIZE_COMPARATOR);
            return closestSize.map(s -> super.resizeTo(s).orElse(null));
        } finally {
            readLock.unlock();
        }
    }

    public boolean addGeneratedSize(AdSize size) {
        if (size == null) {
            return false;
        }

        try {
            writeLock.lock();
            return generatedSizes.add(size);
        } finally {
            writeLock.unlock();
        }

    }

    public boolean removeGeneratedSize(AdSize size) {
        if (size == null) {
            return false;
        }

        try {
            writeLock.lock();
            return generatedSizes.remove(size);
        } finally {
            writeLock.unlock();
        }
    }
}
