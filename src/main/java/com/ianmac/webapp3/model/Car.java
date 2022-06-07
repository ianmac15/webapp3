package com.ianmac.webapp3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Car {


    private String brand;
    private String model;
    private boolean isUsed;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    public Car() {
    }

    public Car(String brand, String model, boolean isUsed) {
        this.brand = brand;
        this.model = model;
        this.isUsed = isUsed;
    }



    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(long id) {this.id = id;}

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }


}
