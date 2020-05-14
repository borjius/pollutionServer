package com.pollution.aq.server.aq.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Location {

    private String id;
    private String country;
    private String city;
    private List<String> cities;
    private String location;
    private List<String> locations;
    private String sourceName;
    private List<String> sourceNames;
    private String sourceType;
    private List<String> sourceTypes;
    private Coordinates coordinates;
    private String firstUpdated;
    private String lastUpdated;
    private List<ParameterLoc> parameters;
    private List<Measurement> countsByMeasurement;
    private int count;

}
