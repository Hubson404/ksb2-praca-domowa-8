import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Forecast} from "./forecast.model";
import {ResponseModel} from "./response.model";

@Injectable({
  providedIn: 'root'
})
export class ForecastService {

  forecasts: Forecast[] = [];

  constructor(private http: HttpClient) {
  }

  getForecasts() {
    return this.http.get<ResponseModel>('http://localhost:8080/api/forecasts')
      .pipe(map(responseData => {
          this.forecasts = responseData.forecasts;
          return this.forecasts;
        })
      );
  }
}

