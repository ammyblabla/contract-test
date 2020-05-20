package com.example.consumer;

import java.io.IOException;

public class Consumer {
    int port = 8111;

    Consumer() {
        System.out.println("Default port: " + port);
    }

    Consumer(int port) {
        this.port = port;
        System.out.println("Port: " + port);
    }

    public static void main(String[] args) throws IOException {
        BusRepository busRepository = new BusRepository();
        BusDto bus = busRepository.getBus("HammerSmith", 613);
        System.out.println("GET DATA " + bus.toString());
    }
}
