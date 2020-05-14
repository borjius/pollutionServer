package com.pollution.aq.server.api;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HistoricalLocationRequestPayload {

    private String country;
    private String city;
    private String location;
    private LocalDate dateFrom;
    private LocalDate dateTo;


}
