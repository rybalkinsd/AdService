package com.example.testassessment.controller.content;


import com.example.testassessment.util.AdSize;

public class Contents {
    public static final Content IMAGE = new Content("image", "http://cdn101.example.com/img/%dx%d.png");
    public static final Content ANIMATION = new Content("animation", "http://cdn202.example.com/img/%dx%d.gif");
    public static final VideoContent VIDEO = new VideoContent("video", "http://cdn303.example.com/video/codec/mp4/%d-%d.mp4");
    static {
        VIDEO.addGeneratedSize(new AdSize(240, 320));
        VIDEO.addGeneratedSize(new AdSize(480, 640));
        VIDEO.addGeneratedSize(new AdSize(720, 1280));
        VIDEO.addGeneratedSize(new AdSize(900, 1440));
    }

    private Contents() { }

}
