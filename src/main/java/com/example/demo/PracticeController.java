package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public String sum(@RequestParam Map querystring) {
        return querystring.toString();
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height){

        Integer volume = length * width * height;

        return "The volume of the rectangle is " + volume.toString();
    }



}
