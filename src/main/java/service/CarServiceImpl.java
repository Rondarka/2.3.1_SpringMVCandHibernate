package service;

import model.Car;

import java.util.List;
import java.util.stream.Stream;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getSomeCars(List<Car> cars, int count) {
        Stream<Car> carsStream = cars.stream().limit(count);
        return carsStream.toList();
    }
}
