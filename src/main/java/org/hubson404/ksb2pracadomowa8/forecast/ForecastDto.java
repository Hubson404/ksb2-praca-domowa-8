package org.hubson404.ksb2pracadomowa8.forecast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDto {

    private Long id;
    private Double temperature;
    private String date;
    private String time;

}
