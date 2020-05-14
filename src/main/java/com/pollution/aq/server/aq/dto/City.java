package com.pollution.aq.server.aq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City {

    private String country;
    private String name;
    private String city;
    private int count;
    private int locations;

}
