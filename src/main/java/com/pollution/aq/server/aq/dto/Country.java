package com.pollution.aq.server.aq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Country {

    private String code;
    private int count;
    private int locations;
    private int cities;
    private String name;
}
