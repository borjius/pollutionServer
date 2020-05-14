package com.pollution.aq.server.api;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MeasurementByDate {

    private LocalDateTime time;
    private int count;

}
