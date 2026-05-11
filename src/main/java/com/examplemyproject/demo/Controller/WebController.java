package com.examplemyproject.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

@Controller // This handles HTML views
public class WebController {

    @GetMapping("/")
    public String sayHello() {
        return "index";
    }

    @GetMapping("/mainPage") // This is your route (URL)
    public String getTimePage(Model model) {
        // The 'Model' is like a PHP associative array ($data = [])
        // We "push" data into it to use in the HTML
        model.addAttribute("serverTime", LocalDateTime.now().toString());
        model.addAttribute("btnString", "return to index");

        // Return the name of the HTML file (without .html extension)
        return "mainPage"; 
    }
}
