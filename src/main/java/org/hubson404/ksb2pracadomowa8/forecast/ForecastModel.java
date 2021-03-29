package org.hubson404.ksb2pracadomowa8.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForecastModel {

    @JsonProperty("main")
    private Main main;
    @JsonProperty("dt")
    private Integer dt;

    @Data
    public static class Main {
        @JsonProperty("temp")
        private Double temp;
    }

}
