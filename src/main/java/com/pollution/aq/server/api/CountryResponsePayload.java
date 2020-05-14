package com.pollution.aq.server.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CountryResponsePayload {

    private String code;
    private String name;
    private int cities;
    private int locations;

}
