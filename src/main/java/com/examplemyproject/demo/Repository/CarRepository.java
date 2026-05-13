package com.examplemyproject.demo.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.examplemyproject.demo.Model.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String>{
    List<Car> findByBrand(String brand);
    List<Car> findByPrice(Double price);
    List<Car> findByModel(String model);
    List<Car> findByType(String type);
}
