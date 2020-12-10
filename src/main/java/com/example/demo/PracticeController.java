package com.example.demo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
public class PracticeController {

    @GetMapping("/math/pi")
    public String helloWorld() {
        return "3.141592653589793";
    }

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y) {

        String value = "";
        if ("add".equals(operation)) {
            Integer sum = x + y;
            value = x + " + " + y + " = " + sum.toString();
        } else if("multiply".equals(operation)) {
            Integer multi = x * y;
            value = x + " * " + y + " = " + multi.toString();
        } else if ("subtract".equals(operation)) {
            Integer sub = x - y;
            value = x + " - " + y + " = " + sub.toString();
        } else if ("divide".equals(operation)) {
            Integer div = x / y;
            value = x + " / " + y + " = " + div.toString();
        }

        return value;

    }

    @GetMapping("/math/sum")
    public String sum(@RequestParam Integer [] n) {
        String value = "";
        int sum = 0;

        for(int i = 0; i < n.length; i++) {
            sum += n[i];
            if (i != n.length - 1) {
                value += n[i].toString() + " + ";
            } else {
                value += n[i].toString() + " = ";
            }



        }

        return value + sum;
    }



    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height){

        Integer volume = length * width * height;

        return "The volume of the rectangle is " + volume.toString();
    }

    @GetMapping("/flights/flight")
    public Flights getflight() {
        Flights flight = new Flights();
        Flights.Ticket ticket1 = new Flights.Ticket();
        Flights.Ticket.Passenger passenger = new Flights.Ticket.Passenger();

        flight.setDeparts(new Date());
        passenger.setFirstname("Avery");
        passenger.setLastname("Merriex");
        ticket1.setPassenger(passenger);
        ticket1.setPrice(200);
        flight.setTickets(Arrays.asList(ticket1));
        return flight;
    }

    @GetMapping("/flights/")
    public  List <Flights> getFlights(){

        Flights flight = new Flights();
        Flights.Ticket ticket1 = new Flights.Ticket();
        Flights.Ticket.Passenger passenger = new Flights.Ticket.Passenger();

        flight.setDeparts(new Date());
        passenger.setFirstname("Avery");
        passenger.setLastname("Merriex");
        ticket1.setPassenger(passenger);
        ticket1.setPrice(200);

        flight.setTickets(Arrays.asList(ticket1));

        Flights flight2 = new Flights();
        Flights.Ticket ticket2 = new Flights.Ticket();
        Flights.Ticket.Passenger passenger2 = new Flights.Ticket.Passenger();

        flight2.setDeparts(new Date());
        passenger2.setFirstname("Some other name");
        passenger2.setLastname("null");
        ticket2.setPassenger(passenger2);
        ticket2.setPrice(400);

        flight2.setTickets(Arrays.asList(ticket2));


        return Arrays.asList(flight, flight2);
    }


}





