package org.hubson404.ksb2pracadomowa8.forecast;

import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class ForecastMapper {

    public ForecastDto mapToForecastDto(Forecast forecast) {
        return new ForecastDto(
                forecast.getId(),
                forecast.getTemperature(),
                forecast.getDate().toLocalDate().toString(),
                forecast.getDate().toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString());
    }

}
