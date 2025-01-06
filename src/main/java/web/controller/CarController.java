package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", required = false) Integer count,
                       Model model) {

        CarService carService = new CarServiceImpl();
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car(2020, "BMW X5", "Black"));
        carsList.add(new Car(2021, "Mercedes-Benz C-Class", "White"));
        carsList.add(new Car(2019, "Audi Q7", "Silver"));
        carsList.add(new Car(2022, "Tesla Model S", "Red"));
        carsList.add(new Car(2018, "Toyota Camry", "Blue"));
        if (count == null) {
            count = carsList.size();
        }
        model.addAttribute("cars", carService.getSomeCars(carsList, count));
        return "cars";
    }

}
