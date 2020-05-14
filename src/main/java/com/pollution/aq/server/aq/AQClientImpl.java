package com.pollution.aq.server.aq;

import com.pollution.aq.server.aq.dto.CityResponse;
import com.pollution.aq.server.aq.dto.CountryResponse;
import com.pollution.aq.server.aq.dto.LocationResponse;
import com.pollution.aq.server.aq.dto.ParameterResponse;
import com.pollution.aq.server.properties.AQProperties;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

@Component
public class AQClientImpl implements AQClient {

    private WebClient aqClient;

    @Autowired
    private AQProperties aqProperties;

    @PostConstruct
    public void setupClient() {
        aqClient = WebClient
            .builder()
            .baseUrl(aqProperties.getUrl())
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    }

    @Override
    public Mono<CityResponse> getCities(String country) {
        final ResponseSpec citiesForCountry = aqClient.get()
            .uri(uriBuilder -> uriBuilder.path(AQUris.GET_ALL_CITIES)
                .queryParam("country", country).build())
            .retrieve();

        return citiesForCountry.bodyToMono(CityResponse.class);
    }

    @Override
    public Mono<CountryResponse> getCountries() {
        final ResponseSpec countries = aqClient.get()
            .uri(AQUris.GET_ALL_COUNTRIES)
            .retrieve();
        return countries.bodyToMono(CountryResponse.class);
    }

    @Override
    public Mono<LocationResponse> getLocations(String country, String city) {
        final ResponseSpec locationsForCountryCity = aqClient.get()
            .uri(uriBuilder -> uriBuilder.path(AQUris.GET_ALL_LOCATIONS)
                .queryParam("city[]", city)
                .queryParam("country[]", country)
                .build())
            .retrieve();
        return locationsForCountryCity.bodyToMono(LocationResponse.class);
    }

    @Override
    public Mono<LocationResponse> getLocationsByParameter(String country, String parameter) {
        final ResponseSpec locationsForCountryCity = aqClient.get()
            .uri(uriBuilder -> uriBuilder.path(AQUris.GET_ALL_LOCATIONS)
                .queryParam("parameter[]", parameter)
                .queryParam("country[]", country)
                .build())
            .retrieve();
        return locationsForCountryCity.bodyToMono(LocationResponse.class);
    }

    @Override
    public Mono<ParameterResponse> getParameters() {
        final ResponseSpec parameters = aqClient.get()
            .uri(AQUris.GET_ALL_PARAMETERS)
            .retrieve();

        return parameters.bodyToMono(ParameterResponse.class);
    }
}
