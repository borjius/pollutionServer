package com.pollution.aq.server.api;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationHistoricalPayload {

    private String id;
    private String country;
    private String city;
    private List<String> location;
    private double latitude;
    private double longitude;
    private Map<String, MeasurementByDate> measurements;

}
