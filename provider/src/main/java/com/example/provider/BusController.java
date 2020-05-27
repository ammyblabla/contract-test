package com.example.provider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {
    @RequestMapping("/bus/{station}/{nr}")
    public BusDto bus(@PathVariable String station, @PathVariable int nr) {
        System.out.println("GET /bus/" + station + "/" + nr);
        int eta = nr + 1;
        return new BusDto(station, nr, eta);
    }
}
