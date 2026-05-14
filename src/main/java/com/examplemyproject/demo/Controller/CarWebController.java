package com.examplemyproject.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examplemyproject.demo.Model.Car;
import com.examplemyproject.demo.Repository.CarRepository;

@Controller
@RequestMapping("/cars")
public class CarWebController {

    @Autowired
    private CarRepository carRepository;
    private String folder = "car/";

    
    // 1. VIEW ALL CARS
    @GetMapping
    public String index(Model model) {
        try {
            List<Car> allCars = carRepository.findAll();
            model.addAttribute("allCars", allCars);
            return folder+"car-list";
        } catch (Exception e) {
            System.out.println("-------------------------- INSIDE CARS FUNCTION error --------------------");
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    // 2. SHOW INSERT FORM
    @GetMapping("/new")
    public String showInsertForm(Model model) {
        model.addAttribute("car", new Car()); // Blank object for form binding
        return folder+"car-form";
    }

    // 3. SHOW UPDATE FORM
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable String id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        model.addAttribute("car", car); // Populated object for editing
        return folder+"car-form";
    }

    // 4. HANDLE SAVE (BOTH INSERT & UPDATE)
    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car) {
        if (car.getId() != null && car.getId().trim().isEmpty()) {
            car.setId(null); 
        }
        carRepository.save(car); // Automatically handles update if ID is present
        return "redirect:/cars"; // Redirect back to view list
    }

    // 5. HANDLE DELETE
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable String id) {
        carRepository.deleteById(id);
        return "redirect:/cars";
    }
}
