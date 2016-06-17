package com.example.testassessment.weirdcode;

public class App {

    private String id;

    private boolean banned;

    private Integer minH;
    private Integer minW;

    private Integer maxH;
    private Integer maxW;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public Integer getMinH() {
        return minH;
    }

    public void setMinH(Integer minH) {
        this.minH = minH;
    }

    public Integer getMinW() {
        return minW;
    }

    public void setMinW(Integer minW) {
        this.minW = minW;
    }

    public Integer getMaxH() {
        return maxH;
    }

    public void setMaxH(Integer maxH) {
        this.maxH = maxH;
    }

    public Integer getMaxW() {
        return maxW;
    }

    public void setMaxW(Integer maxW) {
        this.maxW = maxW;
    }
}
