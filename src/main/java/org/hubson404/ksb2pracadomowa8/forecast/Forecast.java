package org.hubson404.ksb2pracadomowa8.forecast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Forecast {

    @Id
    @GeneratedValue
    private Long id;

    private Double temperature;
    private Long dt;

    @CreationTimestamp
    private LocalDateTime date;

    public Forecast(Double temperature, Long dt) {
        this.temperature = temperature;
        this.dt = dt;
    }
}
