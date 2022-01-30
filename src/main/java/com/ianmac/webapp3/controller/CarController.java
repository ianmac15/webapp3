package com.ianmac.webapp3.controller;

import com.ianmac.webapp3.exceptions.ResourceNotFoundException;
import com.ianmac.webapp3.model.Car;
import com.ianmac.webapp3.repository.CarRepository;
import com.ianmac.webapp3.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private CarRepository carRepository;


    @GetMapping("car/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("car/{id}")
    public Car getCar(@PathVariable(value = "id") long id) {

        return carService.getCarById(id);
//        Car user = this.carRepository.findById(id).orElseThrow(
//                ()-> new ResourceNotFoundException("User not found")
//        );
//
//        return  ResponseEntity.ok().body(user);


    }

    @PostMapping("car/save")
    public Car addCar(@RequestBody Car car) {
        Car car1 = carService.saveCar(car);
        return car1;
    }

    @PutMapping("car/{id}")
    public Car updateCar(@PathVariable(value = "id") long id, @RequestBody Car car) {
        Car car1 = carService.updateCar(id, car);
        return car1;
//        return new ResponseEntity<>(car1, HttpStatus.OK);
    }

    @DeleteMapping("car/{id}")
    public void deleteCar(@PathVariable(value = "id") long id) {
        carService.deleteCarById(id);
    }

    @DeleteMapping("car/all")
    public void deleteAllCars() {
        carService.deleteAllCars();
    }


//    @PostMapping("addCar")
//    public ResponseEntity<Object> addNewCar(@RequestBody Car car) {
//        carService.saveCar(car);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(car.getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }

//    @PostMapping("newcar/{carVariables}")
//    public String newCar(@PathVariable(value = "carVariables") String[] aCar) {
//        carService.saveCar(new Car(aCar[0],aCar[1],aCar[2]));
//        return "Car " + aCar[0] + " has been added to the list.";
//    }


}
