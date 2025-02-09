package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carService = carServiceImpl;
    }

    @GetMapping("/cars")
    public String carTable(@RequestParam(value = "count", required = false,
            defaultValue = "5") int count, Model model) {

        model.addAttribute("cars", carService.getCarsByCount(count));

        return "cars";
    }
}
