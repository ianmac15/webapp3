package com.ianmac.webapp3.controller;

import com.ianmac.webapp3.exceptions.ResourceNotFoundException;
import com.ianmac.webapp3.model.Car;
import com.ianmac.webapp3.repository.CarRepository;
import com.ianmac.webapp3.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    final private CarServiceImpl carService;

    @Autowired
    private CarRepository carRepository;


//    public CarController(CarRepository carRepository) {
//        this.carRepository = carRepository;
//    }

        public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable(value = "id") Long id) {
        return carService.getCarById(id);
    }

//    @GetMapping
//    public ResponseEntity<List<Car>> getAllCars(){
//        return ResponseEntity.ok(this.carRepository.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Car> getCar(@PathVariable(value = "id") Long id) {
//        Car car = carRepository.findById(id).
//                orElseThrow(() -> new ResourceNotFoundException("Car not found"));
//        return ResponseEntity.ok().body(car);
//    }
//
//    @PostMapping
//    public ResponseEntity addCar(@RequestBody Car car) throws URISyntaxException {
//        Car savedCar = carRepository.save(car);
//        return ResponseEntity.created(new URI("/cars/"+savedCar.getId())).body(savedCar);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity updateCar(@PathVariable Long id, @RequestBody Car car) {
//        Car currentCar = carRepository.findById(id).orElseThrow(RuntimeException::new);
//        currentCar.setBrand(car.getBrand());
//        currentCar.setModel(car.getModel());
//        currentCar.setUsed(car.getIsUsed());
//
//        return ResponseEntity.ok(currentCar);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteCar(@PathVariable Long id) {
//        carRepository.deleteById(id);
//        return ResponseEntity.ok().build();
//    }


    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable(value = "id") long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
//        return new ResponseEntity<>(car1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable(value = "id") long id) {
        carService.deleteCarById(id);
    }

    @DeleteMapping
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
