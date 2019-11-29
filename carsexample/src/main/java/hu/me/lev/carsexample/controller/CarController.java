package hu.me.lev.carsexample.controller;

import hu.me.lev.carsexample.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("addCar")
    @ResponseBody
    public void addCar(@Valid @RequestBody CarDTO carDTO,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        }
        carService.addCar(carDTO);

    }

    @GetMapping("getAllCar")
    @ResponseBody
    public List<CarDTO> getAllCar() {
        return carService.getAllCar();
    }


}
