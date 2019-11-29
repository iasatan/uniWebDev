package hu.me.lev.carsexample.controller;

import hu.me.lev.carsexample.persist.ManufacturerEntity;
import hu.me.lev.carsexample.service.ManufacturerService;
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
public class ManufacturerController {
    private ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping("addMan")
    @ResponseBody
    public void addManufacturer(@Valid @RequestBody ManufacturerEntity manufacturerEntity
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        }
        manufacturerService.addManufacturer(manufacturerEntity);
    }

    @GetMapping("getAllMan")
    @ResponseBody
    public List<ManufacturerEntity> manufacturerEntities() {
        return manufacturerService.getManufacturers();
    }
}
