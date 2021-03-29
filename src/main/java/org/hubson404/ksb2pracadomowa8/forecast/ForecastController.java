package org.hubson404.ksb2pracadomowa8.forecast;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping("/api/forecasts")
    public ForecastWrapper getLastDaysForecasts() {
        return forecastService.getLastDaysForecasts();
    }
}
