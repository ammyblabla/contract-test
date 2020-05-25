package com.example.provider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BusController {
    @RequestMapping("/bus/{station}/{nr}")
    public BusDto bus(@PathVariable String station, @PathVariable int nr) {
        int eta = nr + 1;
        BusDto b = new BusDto(station, nr, eta);
        return b;
    }
}
