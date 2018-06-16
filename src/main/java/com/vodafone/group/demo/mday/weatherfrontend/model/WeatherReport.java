package com.vodafone.group.demo.mday.weatherfrontend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeatherReport {
	@JsonProperty("city_name")
	private String cityName;
	private List<WeatherEntry> weather;

}
