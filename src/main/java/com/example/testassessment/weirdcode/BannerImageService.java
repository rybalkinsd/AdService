package com.example.testassessment.weirdcode;

public class BannerImageService {

    /**
     * Generates advertisement content "on-the-fly". Generated content will fit perfect into ad space size.
     *
     * @param adType type of advertisement
     * @param h height of advertisement
     * @param w width of advertisement
     * @return URL of file which should be displayed on client side
     */
    public String bannerImage(String adType, int h, int w) {
        if (adType.equals("image")) {
            return "http://cdn101.example.com/img/"+h+"x"+w+".png";
        } else if (adType.equals("animation")) {
            return "http://cdn202.example.com/img/"+h+"x"+w+".gif";
        } else if (adType.equals("video")) {
            return "http://cdn303.example.com/video/codec/mp4/"+h+"-"+w+".mp4";
        } else {
            throw new RuntimeException("No banner found!");
        }
    }
    
}
