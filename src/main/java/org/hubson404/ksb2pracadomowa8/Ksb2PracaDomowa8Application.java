package org.hubson404.ksb2pracadomowa8;

import lombok.RequiredArgsConstructor;
import org.hubson404.ksb2pracadomowa8.forecast.ForecastService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
public class Ksb2PracaDomowa8Application {

    private final ForecastService forecastService;

    public static void main(String[] args) {
        SpringApplication.run(Ksb2PracaDomowa8Application.class, args);
    }

}
