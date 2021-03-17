package com.tts.cap.controller;

import com.tts.cap.model.Quote;
import com.tts.cap.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/quote")
@RestController
public class QuoteController {
    @Autowired
    QuoteService quoteService;


    @RequestMapping
    public Quote getInfo(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(
                "http://quotes.rest/qod/art", Quote.class
        );
        return new Quote(quote.getQuote(), quote.getAuthor());
        }
    }



