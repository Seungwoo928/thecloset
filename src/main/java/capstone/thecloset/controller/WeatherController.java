package capstone.thecloset.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    @GetMapping(value = "/board/weather.do")
    public String openWeatherPage(){
        return "/weather/weather";
    }
}
