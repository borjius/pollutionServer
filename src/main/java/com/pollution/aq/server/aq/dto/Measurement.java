package com.pollution.aq.server.aq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Measurement {

    private String parameter;
    private int count;

}
