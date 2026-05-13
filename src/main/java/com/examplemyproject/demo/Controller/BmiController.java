package com.examplemyproject.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @GetMapping("/bmi")
    public String showForm() {
        return "bmi-form"; // Refers to bmi-form.html
    }

    @PostMapping("/calculate")
    public String calculateBmi(@RequestParam("weight") double weight,
                               @RequestParam("height") double height,
                               Model model) {
        // BMI Formula: kg / m^2
        double bmi = weight / (height * height);
        String category = calculateCategory(bmi);
        
        model.addAttribute("bmi", String.format("%.2f", bmi));
        model.addAttribute("category", category);
        return "bmi-form";
    }

    private String calculateCategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }
}
