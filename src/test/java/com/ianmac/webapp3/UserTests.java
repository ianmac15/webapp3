package com.ianmac.webapp3;

import com.ianmac.webapp3.model.Car;
import com.ianmac.webapp3.repository.CarRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserTests {

//    @Autowired
    private final CarRepository carRepository;

    public UserTests(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Test
    public void testSaveCar() {

        Car car1 = new Car("Toyota","Supra", "Orange");
        carRepository.save(car1);
        Optional<Car> newCarCar = carRepository.findById(Long.valueOf(1));
        Car newCar = newCarCar.get();
        Assert.assertEquals("Toyota", newCar.getBrand());

    }
}
