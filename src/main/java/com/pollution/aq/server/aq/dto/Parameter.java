package com.pollution.aq.server.aq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Parameter {

    private String code;
    private String name;
    private String description;
    private String preferredUnit;

}
