package com.devlog.piano.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String aboutPage() {
        return "about/about";
    }
}
