package com.example.testassessment.repository.mock;

import com.example.testassessment.repository.AdPlace;
import com.example.testassessment.repository.App;
import com.example.testassessment.util.AdSize;

public class MockConstants {
    private static final String BOUNDED_APP_ID = "2e95de7a-12c3-421f-b6dd-fe19623a3763";
    public static  final App BOUNDED_APP = new App();
    static {
        BOUNDED_APP.setId(BOUNDED_APP_ID);
        BOUNDED_APP.setAdMinSize(new AdSize(100, 100));
        BOUNDED_APP.setAdMaxSize(new AdSize(200, 200));
    }

    private static final String UNBOUNDED_APP_ID = "2e95de7a-12c3-421f-b6dd-fe19623a3742";
    public static  final App UNBOUNDED_APP = new App();
    static {
        UNBOUNDED_APP.setId(UNBOUNDED_APP_ID);
    }

    public static final String ANIM_AD_PLACE_ID = "1f855d85-6b3b-4113-af6b-c87b1b39e185";
    private static final String ANIM_AD_PLACE_TYPE = "animation";
    public static final AdPlace ANIM_AD_PLACE = new AdPlace();
    static {
        ANIM_AD_PLACE.setId(ANIM_AD_PLACE_ID);
        ANIM_AD_PLACE.setAppId(BOUNDED_APP_ID);
        ANIM_AD_PLACE.setType(MockConstants.ANIM_AD_PLACE_TYPE);

    }

    public static final String VIDEO_AD_PLACE_ID = "1f855d85-6b3b-4113-af6b-c87b1b39e142";
    private static final String VIDEO_AD_PLACE_TYPE = "video";
    public static final AdPlace VIDEO_AD_PLACE = new AdPlace();
    static {
        VIDEO_AD_PLACE.setId(VIDEO_AD_PLACE_ID);
        VIDEO_AD_PLACE.setAppId(UNBOUNDED_APP_ID);
        VIDEO_AD_PLACE.setType(VIDEO_AD_PLACE_TYPE);
    }

    private MockConstants() { }
}
