package com.example.testassessment.weirdcode;

import java.util.HashMap;
import java.util.Map;

public class Facade {

    private UserBannerService bannerService;
    private AdPlaceRepository adPlaceRepository;

    public void setBannerService(UserBannerService bannerService) {
        this.bannerService = bannerService;
    }

    /**
     * @return JSON with advertisement that client should render
     */
    public String serveAd(String jsonString) {
        String s = jsonString.replaceAll("^\\{|\\}$", "");
        String[] parts = s.substring(1, s.length()).split("\"?(:|,)(?![^\\{]*\\})\"?");
        Map<String, String> request = new HashMap<String, String>();
        for (int i = 0; i < parts.length -1; i+=2) {
            request.put(parts[i], parts[i + 1]);
        }
        String banner;
        try {
            banner = bannerService.getBanner(request.get("adPlaceId"), Integer.valueOf(request.get("h")), Integer.valueOf(request.get("w")));
        } catch (Exception e) {
            banner = null;
        }
        AdPlace adPlace = adPlaceRepository.findById(request.get("adPlaceId"));

        if (banner == null) {
            return "{}";
        } else {
            return "{\"url\":\""+banner+"\",\"type\":\""+adPlace.getType()+"\"}";
        }
    }
    
    public void setAdPlaceRepository(AdPlaceRepository adPlaceRepository) {
        this.adPlaceRepository = adPlaceRepository;
    }
}
