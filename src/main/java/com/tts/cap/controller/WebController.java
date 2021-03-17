package com.tts.cap.controller;


import com.tts.cap.model.Subscriber;
import com.tts.cap.repository.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
@ControllerAdvice
public class WebController implements WebMvcConfigurer {

    @Autowired
    SubscriberRepo subscriberRepo;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/subscribed").setViewName("subscribed");
    }

    @GetMapping("/subscriber")
    public String showSubscriber(Subscriber subscriber) {
        return "subscriber.html";
    }

/*    @PostMapping("/subscriber")
    public String checkSubscriber(@Valid Subscriber subscriber, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "subscriber";
        }

        return "redirect:/subscribed";
    }*/
    @PostMapping(value = "/")
    public String addNewSubscriber(Subscriber subscriber, Model model) {
        subscriberRepo.save(new Subscriber(subscriber.getName(), subscriber.getEmail()));
        model.addAttribute("name", subscriber.getName());
        model.addAttribute("email", subscriber.getEmail());
        return "redirect:/subscribe";
    }

}
