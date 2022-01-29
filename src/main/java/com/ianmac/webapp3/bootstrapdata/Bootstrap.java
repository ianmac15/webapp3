//package com.ianmac.webapp3.bootstrapdata;
//
//import com.ianmac.webapp3.model.Car;
//import com.ianmac.webapp3.repository.CarRepository;
//import com.ianmac.webapp3.service.CarService;
//import com.ianmac.webapp3.service.CarServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Bootstrap implements CommandLineRunner {
//
//    @Autowired
//    private CarRepository carRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Car car1 = new Car("Toyota", "Corolla", "Red");
//        Car car2 = new Car("Mitsubishi", "Evo", "Blue");
//
//        carRepository.save(car1);
//        carRepository.save(car2);
//    }
//}
