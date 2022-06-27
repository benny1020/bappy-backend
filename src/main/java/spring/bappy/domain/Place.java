package spring.bappy.domain;

import lombok.Data;

@Data
public class Place {
    private String placeName;
    private String placeLatitude;
    private String placeLongitude;
    private String placeAddress;

}
