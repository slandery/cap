package com.tts.cap.controller;

import com.tts.cap.model.Quote;
import com.tts.cap.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/quote")
@RestController
public class QuoteController {
    @Autowired
    QuoteService quoteService;

    @PatchMapping
    public String postInfo(Quote quote, Model model) {
        Quote data = quoteService.quoteOfDay(quote.getQuote());
        model.addAttribute("Quote", quote.getQuote());
        model.addAttribute("Author", quote.getAuthor());
        return String.valueOf(data);
    }


/*
    @RequestMapping
    public Quote getInfo(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(
                "http://quotes.rest/qod/art", Quote.class);
        return restTemplate.getForObject(url, Quote.class);
        return new Quote(quote.getQuote(), quote.getAuthor());
        }

         return restTemplate.getForObject(url, Quote.class);*/
    }




