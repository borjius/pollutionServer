package com.pollution.aq.server.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CityResponsePayload {

    private String country;
    private String city;
    private int count;
    private int locations;

}
