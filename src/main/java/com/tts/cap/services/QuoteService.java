package com.tts.cap.services;

import com.tts.cap.model.Quote;
import com.tts.cap.model.QuoteResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {
    public Quote quoteOfDay(String quote){
        String url = "http://quotes.rest/qod/art";

        try{
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, Quote.class);
        } catch (HttpClientErrorException ex) {
            Quote info = new Quote();
            info.setQuote("error");
            return info;
        }
    }



//    String url = "http://quotes.rest/qod/art" + quote.getQuote() + quote.getAuthor();
//
//    RestTemplate restTemplate = new RestTemplate();
//    QuoteResponse response = restTemplate.getForObject(url , QuoteResponse.class);
//    /*        Quote results = response.getResults().get(0).getQuote();*/
}
