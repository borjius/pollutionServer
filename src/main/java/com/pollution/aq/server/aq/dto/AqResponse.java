package com.pollution.aq.server.aq.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AqResponse<T> {

    private Meta meta;
    private List<T> results;

}
