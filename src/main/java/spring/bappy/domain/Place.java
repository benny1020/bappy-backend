package spring.bappy.domain;

import lombok.Data;

@Data
public class Place {
    private String placeName;
    private float placeLatitude;
    private float placeLongitude;
    private String placeAddress;
    private String placeUrl;
    private String placeId;


    public Place() {
        placeName = "";
        placeLatitude = 0.0f;
        placeLongitude = 0.0f;
        placeAddress = "";
        placeUrl = "";
        placeId = "";

    }

}
