package com.pollution.aq.server.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ParameterResponsePayload {

    private String name;
    private String description;
    private String preferredUnit;

}
