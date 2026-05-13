package com.examplemyproject.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplemyproject.demo.Model.Car;
import com.examplemyproject.demo.Repository.CarRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll(); // Fetches all documents from the cars collection
    }

    @GetMapping("/{id}")
    public Optional<Car> getById(@PathVariable String id) {
        return carRepository.findById(id);
    }
    
    @GetMapping("/search")
    public List<Car> getBySearch(@RequestParam String brand, String model, String type, double price) {
        if(brand != null){
            return carRepository.findByBrand(brand);
        }else if(model != null){
            return carRepository.findByModel(model);
        }else if(type != null){
            return carRepository.findByType(type);
        }else if(price != 0){
            return carRepository.findByPrice(price);
        }else{
            return carRepository.findAll();
        }
    }

    @PostMapping("/save")
    public Car saveCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.ok("Car deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
    }
}
