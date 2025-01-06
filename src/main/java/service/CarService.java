package service;

import model.Car;

import java.util.List;

public interface CarService {
    List<Car> getSomeCars(List<Car> cars, int count);
}
