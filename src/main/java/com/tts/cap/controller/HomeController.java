package com.tts.cap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

   @GetMapping("/")
    public String home() {
        return "home.html";
    }


    @GetMapping("/collections")
    public String collection(){
        return "collections.html";
    }

    @GetMapping("/about")
    public String scollection(){
        return "scollection.html";
    }

}



