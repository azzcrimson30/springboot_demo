package com.examplemyproject.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.examplemyproject.demo.Model.Car;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String listCars(Model model) {
        // Acting as your database
        List<Car> carList = Arrays.asList(
            new Car("Toyota", "Sedan", 25000.00),
            new Car("Honda", "SUV", 30000.00),
            new Car("Tesla", "Electric", 50000.00)
        );

        // This is like: $data['allCars'] = $carList;
        model.addAttribute("allCars", carList);
        
        return "car-list"; // name of your HTML file
    }
}
