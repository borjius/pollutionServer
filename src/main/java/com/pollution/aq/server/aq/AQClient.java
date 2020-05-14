package com.pollution.aq.server.aq;

import com.pollution.aq.server.aq.dto.CityResponse;
import com.pollution.aq.server.aq.dto.CountryResponse;
import com.pollution.aq.server.aq.dto.LocationResponse;
import com.pollution.aq.server.aq.dto.ParameterResponse;
import reactor.core.publisher.Mono;

public interface AQClient {

    /**
     * get all cities available on data store by country
     * @param country country where to filter cities available
     */
    Mono<CityResponse> getCities(String country);

    /**
     * get all countries available on data store
     */
    Mono<CountryResponse> getCountries();

    /**
     * get locations from specific country, city
     * @param country country to filter
     * @param city city to filter
     * @return locations in place
     */
    Mono<LocationResponse> getLocations(String country, String city);

    /**
     * Get all locations by parameter
     * @param country
     * @param parameter
     * @return
     */
    Mono<LocationResponse> getLocationsByParameter(String country, String parameter);

    /**
     * Get all parameters available from aq data store
     * @return parameters
     */
    Mono<ParameterResponse> getParameters();
}
