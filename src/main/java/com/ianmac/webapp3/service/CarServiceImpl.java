package com.ianmac.webapp3.service;

import com.ianmac.webapp3.model.Car;
import com.ianmac.webapp3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {

        return carRepository.save(car);

    }

    @Override
    public Car getCarById(long id) {
        Optional<Car> carToFind = carRepository.findById(id);
        Car car = null;

        if (carToFind.isPresent()) {
            car = carToFind.get();
        } else {
            throw new RuntimeException("Car with id: " + id + ", not found");

        }
        return car;
    }

    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void deleteAllCars() {
        carRepository.deleteAll();
    }

    @Override
    public Car updateCar(long id, Car car) {
        Car car1 = getCarById(id);
        car1.setBrand(car.getBrand());
        car1.setModel(car.getModel());
        car1.setColour(car.getColour());
        return carRepository.save(car1);
    }
}
