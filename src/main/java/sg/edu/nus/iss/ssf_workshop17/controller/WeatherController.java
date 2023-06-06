package sg.edu.nus.iss.ssf_workshop17.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.ssf_workshop17.model.openweather.Weather;
import sg.edu.nus.iss.ssf_workshop17.service.WeatherService;

@Controller
@RequestMapping(path="/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public String getWeather(@RequestParam(required=true) String city,
    @RequestParam(defaultValue= "metric",required = false) String units, Model model) throws IOException{
        Optional<Weather> weather = weatherService.getWeather(city, units);
        model.addAttribute("weather", weather.get());
        return "weather";
    }
    
}