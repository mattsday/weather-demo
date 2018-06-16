package com.vodafone.group.demo.mday.weatherfrontend.gui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vodafone.group.demo.mday.weatherfrontend.model.WeatherReport;
import com.vodafone.group.demo.mday.weatherfrontend.services.WeatherForecastService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Presentation {

	@NonNull
	private WeatherForecastService forecastService;

	@Value("${weather.city}")
	String defaultCity;

	@Value("${weather.company}")
	String company;

	@GetMapping("/")
	public String getIndexDefaultCity(Model model) {
		model = getModel(model, defaultCity);
		return "index";
	}

	@GetMapping("/city/{city}")
	public String getIndex(Model model, @PathVariable(name = "city") String city) {
		model = getModel(model, city);
		return "index";
	}

	private Model getModel(Model model, String city) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MM", Locale.UK);
		LocalDateTime now = LocalDateTime.now();

		WeatherReport weather = forecastService.getWeather(city);
		model.addAttribute("weather", weather);
		model.addAttribute("date", dtf.format(now));
		model.addAttribute("company", company);

		return model;
	}
}
