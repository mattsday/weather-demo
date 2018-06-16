package com.vodafone.group.demo.mday.weatherfrontend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vodafone.group.demo.mday.weatherfrontend.model.WeatherReport;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class WeatherForecastService {

	@Value("${weather.service.uri}")
	private String uri;

	@NonNull
	private RestTemplate restTemplate;

	public WeatherReport getWeather(String city) {
		return restTemplate.getForObject(uri + "/" + city, WeatherReport.class);
	}

}
