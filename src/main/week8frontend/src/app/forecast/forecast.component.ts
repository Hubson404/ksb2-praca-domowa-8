import {Component, OnInit} from '@angular/core';
import {ForecastService} from "./forecast.service";
import {Forecast} from "./forecast.model";

@Component({
  selector: 'app-forecast',
  templateUrl: './forecast.component.html',
  styleUrls: ['./forecast.component.css']
})
export class ForecastComponent implements OnInit {

  forecasts: Forecast[] = [];

  constructor(private forecastService: ForecastService) {
  }

  ngOnInit(): void {
    this.onFetchCars();
  }

  onFetchCars() {
    this.forecastService.getForecasts()
      .subscribe(
        responseData => {
          this.forecasts = responseData;
        })
  }
}
