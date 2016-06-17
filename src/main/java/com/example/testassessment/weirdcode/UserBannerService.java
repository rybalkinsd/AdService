package com.example.testassessment.weirdcode;

public class UserBannerService {

    private AdPlaceRepository adPlaceRepository;
    private AppRepository appRepository;
    private BannerImageService imageService;

    public void setAdPlaceRepository(AdPlaceRepository adPlaceRepository) {
        this.adPlaceRepository = adPlaceRepository;
    }

    public void setAppRepository(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public void setImageService(BannerImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * @return URL of advertisement with proper type and size
     */
    public String getBanner(String adPlaceId, int realH, int realW) throws Exception {
        AdPlace place = adPlaceRepository.findById(adPlaceId);
        App app = appRepository.findById(place.getAppId());
        if (app.getBanned()) {
            throw new Exception("App is banned");
        } else {
            Integer minH = app.getMinH();
            Integer minW = app.getMinW();
            if (minH != null && minW != null) {
                if (realH < minH || realW < minW) {
                    return null;
                }
            }
            Integer maxH = app.getMaxH();
            Integer maxW = app.getMaxW();
            String img;
            if (maxH != null && maxW != null && (realH > maxH || realW > maxW)) {
                return imageService.bannerImage(place.getType(), maxH, maxW);
            } else {
                return imageService.bannerImage(place.getType(), realH, realW);
            }
        }
    }

}
