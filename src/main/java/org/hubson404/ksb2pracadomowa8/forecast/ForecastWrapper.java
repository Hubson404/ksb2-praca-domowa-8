package org.hubson404.ksb2pracadomowa8.forecast;

import java.util.List;

public class ForecastWrapper {

    private List<ForecastDto> forecasts;

    public ForecastWrapper(List<ForecastDto> forecasts) {
        this.forecasts = forecasts;
    }

    public ForecastWrapper() {
    }

    public List<ForecastDto> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastDto> forecasts) {
        this.forecasts = forecasts;
    }
}
