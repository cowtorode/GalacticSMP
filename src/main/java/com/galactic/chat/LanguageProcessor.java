package com.galactic.chat;

import java.util.Map;

public class LanguageProcessor
{
    private final Map<String, String> brain = Map.of("hi bettie", "Hello!", "bye bettie", "Goodbye!");

    public String stimulate(String stimulus)
    {
//        StringBuffer buffer = new StringBuffer(stimulus);
//        buffer.split(".,;: ");

        stimulus = stimulus.toLowerCase();
        String s = brain.get(stimulus);

        if (s == null && stimulus.contains("bettie"))
        {
            return "I heard you talking about me O.O";
        }

        return s;
    }
}
