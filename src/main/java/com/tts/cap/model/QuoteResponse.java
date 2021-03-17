package com.tts.cap.model;

import java.util.List;

public class QuoteResponse {
    private List<Quote> results;

    public QuoteResponse(List<Quote> results) {
        this.results = results;
    }

    public List<Quote> getResults() {
        return results;
    }

    public void setResults(List<Quote> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        return "QuoteResponse{" +
                "results=" + results +
                '}';
    }
}
