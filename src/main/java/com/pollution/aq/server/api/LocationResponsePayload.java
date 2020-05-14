package com.pollution.aq.server.api;

import com.pollution.aq.server.aq.dto.ParameterLoc;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LocationResponsePayload {

    private String id;
    private String country;
    private String city;
    private List<String> location;
    private double latitude;
    private double longitude;
    private List<ParameterLoc> parameters;
    private int count;

}
