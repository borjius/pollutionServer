package com.pollution.aq.server.aq.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Meta {

    private String name;
    private String license;
    private String website;
    private int page;
    private int limit;
    private int found;

}
