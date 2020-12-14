package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WordCounter {


    public Map<String, Integer> count(String letters){
        HashMap<String, Integer> help = new HashMap<>();


        String [] lowerCase = letters.toLowerCase().split(" ");

        for(int i = 0; i < lowerCase.length; i++) {
            if (!help.containsKey(lowerCase[i])) {
                help.put(lowerCase[i], 1);
            } else {
                Integer count = help.get(lowerCase[i]);
                help.put(lowerCase[i], count + 1);

            }

        }

        return help;

    }
}
