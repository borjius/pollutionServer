package com.pollution.aq.server;

import com.pollution.aq.server.api.CityResponsePayload;
import com.pollution.aq.server.api.CountryResponsePayload;
import com.pollution.aq.server.api.HistoricalLocationRequestPayload;
import com.pollution.aq.server.api.LocationHistoricalPayload;
import com.pollution.aq.server.api.LocationResponsePayload;
import com.pollution.aq.server.api.ParameterResponsePayload;
import com.pollution.aq.server.aq.AQClient;
import com.pollution.aq.server.aq.dto.CityResponse;
import com.pollution.aq.server.aq.dto.CountryResponse;
import com.pollution.aq.server.aq.dto.LocationResponse;
import com.pollution.aq.server.aq.dto.ParameterResponse;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AQController {

    @Autowired
    private AQClient aqClient;

    @GetMapping("/countries")
    public Flux<CountryResponsePayload> getAllCountries() {
        final Mono<CountryResponse> countriesAq = aqClient.getCountries();
        return countriesAq.map(CountryResponse::getResults)
            .flatMapMany(Flux::fromIterable)
            .map(country -> new CountryResponsePayload(country.getCode(), country.getName(), country.getCities(),
                country.getLocations()));
    }

    @GetMapping("/{country}/cities")
    public Flux<CityResponsePayload> getCitiesByCountry(@PathVariable("country") String country) {
        final Mono<CityResponse> citiesAq = aqClient.getCities(country);
        return citiesAq.map(CityResponse::getResults)
            .flatMapMany(Flux::fromIterable)
            .map(city -> new CityResponsePayload(city.getCountry(), city.getCity(), city.getCount(),
                city.getLocations()));
    }



    @GetMapping("/{country}/parameter/{parameter}")
    public Flux<LocationResponsePayload> getLocationsFromCountryByParameter(@PathVariable("country") String country,
        @PathVariable("parameter") String parameter) {
        final Mono<LocationResponse> locationsAq = aqClient.getLocationsByParameter(country, parameter);

        return locationsAq.map(LocationResponse::getResults).flatMapMany(Flux::fromIterable).map(
            location -> new LocationResponsePayload(location.getId(), location.getCountry(), location.getCity(),
                location.getLocations(), location.getCoordinates().getLatitude(),
                location.getCoordinates().getLongitude(), location.getParameters().stream().filter(param -> parameter.equals(param)).collect(
                Collectors.toList()), location.getCount()));

    }

    @GetMapping("/{country}/{city}/locations")
    public Flux<LocationResponsePayload> getLocations(@PathVariable("country") String country,
        @PathVariable("city") String city) {
        final Mono<LocationResponse> locationsAq = aqClient.getLocations(country, city);
        return locationsAq.map(LocationResponse::getResults).flatMapMany(Flux::fromIterable).map(
            location -> new LocationResponsePayload(location.getId(), location.getCountry(), location.getCity(),
                location.getLocations(), location.getCoordinates().getLatitude(),
                location.getCoordinates().getLongitude(), location.getParameters(), location.getCount()));
    }

    @GetMapping("/parameters")
    public Flux<ParameterResponsePayload> getParameters() {
        final Mono<ParameterResponse> parametersAq = aqClient.getParameters();
        return parametersAq.map(ParameterResponse::getResults).flatMapMany(Flux::fromIterable).map(
            parameter -> new ParameterResponsePayload(parameter.getCode(), parameter.getDescription(),
                parameter.getPreferredUnit()));
    }


    @PostMapping("/location/historical")
    public Flux<LocationHistoricalPayload> getHistoricalForLocation(@RequestBody HistoricalLocationRequestPayload requestPayload) {

        return Flux.just(null);
    }


}
