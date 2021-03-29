package org.hubson404.ksb2pracadomowa8.forecast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hubson404.ksb2pracadomowa8.exceptions.BadRequestException;
import org.hubson404.ksb2pracadomowa8.exceptions.DataProcessingErrorException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ForecastService {

    private final ForecastRepository forecastRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ForecastMapper forecastMapper;

    private Forecast getForecastFromRemoteService() {

        UriComponents build = UriComponentsBuilder
                .fromHttpUrl("http://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", "Warsaw")
                .queryParam("appid", "65bf43aa8dc4a2f7dc96da824bbc8205")
                .queryParam("units", "metric")
                .queryParam("lang", "en")
                .build();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(build.toUri(), String.class);

        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new BadRequestException("Unable to get data from remote service.");
        }

        String responseBody = responseEntity.getBody();
        Forecast forecast;

        try {
            ForecastModel forecastModel = objectMapper.readValue(responseBody, ForecastModel.class);
            forecast = new Forecast(forecastModel.getMain().getTemp(), (long) forecastModel.getDt());
        } catch (JsonProcessingException e) {
            throw new DataProcessingErrorException("Unable to process forecast data.");
        }
        return forecast;
    }

    @Scheduled(cron = "0 5 * * * *")
    private void saveForecastData() {
        Forecast forecastData = getForecastFromRemoteService();
        forecastRepository.save(forecastData);
        log.info("New weather data obtained and saved to DB.");
    }

    public ForecastWrapper getLastDaysForecasts() {
        List<Forecast> lastDayForecasts = forecastRepository.findAll()
                .stream()
                .limit(24)
                .collect(Collectors.toList());
        return wrapForecastList(lastDayForecasts);
    }

    private ForecastWrapper wrapForecastList(List<Forecast> forecastsList) {
        List<ForecastDto> mappedList = forecastsList.stream()
                .map(forecastMapper::mapToForecastDto)
                .collect(Collectors.toList());
        Collections.reverse(mappedList);

        return new ForecastWrapper(mappedList);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void insertDataToDb() {
        Forecast forecastData = getForecastFromRemoteService();
        forecastRepository.save(forecastData);
    }


}
