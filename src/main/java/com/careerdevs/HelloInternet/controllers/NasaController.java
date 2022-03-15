package com.careerdevs.HelloInternet.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/nasa")
public class NasaController {

    @Autowired
    private Environment env;

//    private String myNasaKey = "uJvcfcd7qUcb0d9LbzBjZMNyfxXspR3girJPjKNH";
//
//    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;

    @GetMapping("/apod")
    private Object apodHandler (RestTemplate restTemplate) {

        String apodKey = env.getProperty("NASA_API_KEY", "DEMO_KEY");

        String URL = "https://api.nasa.gov/planetary/apod?api_key=" + apodKey;

        Object response = restTemplate.getForObject(URL, Object.class);

        System.out.println(response);
        return response;
        //        return restTemplate.getForObject(nasaApodEndpoint + apiKey, Object.class);
    }

//    @Override
//    public String toString() {
//        return "NasaController{" + "env=" + env + ", nasaApodEndpoint='" + nasaApodEndpoint + '\'' + '}';
//    }

    @GetMapping("port")
    public String portTest () {

        return env.getProperty("server.port");
    }

    @PostMapping ("/info")
    public String apodInfo () {
        return "NASA APOD provides daily astro-photography photos/videos";
    }
}
