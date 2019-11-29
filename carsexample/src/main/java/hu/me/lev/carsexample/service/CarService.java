package hu.me.lev.carsexample.service;

import hu.me.lev.carsexample.controller.CarDTO;
import hu.me.lev.carsexample.persist.CarEntity;
import hu.me.lev.carsexample.persist.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;
    private ManufacturerService manufacturerService;

    @Autowired
    public CarService(CarRepository carRepository, ManufacturerService manufacturerService) {
        this.carRepository = carRepository;
        this.manufacturerService = manufacturerService;
    }

    public void addCar(CarDTO carDTO) {
        CarEntity carEntity = new CarEntity();
        carEntity.setId(carDTO.getId());
        carEntity.setName(carDTO.getName());
        carEntity.setColor(carDTO.getColor());
        carEntity.setAvailable(carDTO.getAvailable());
        carEntity.setManufacturerEntity(
                manufacturerService.getManufacturer(carDTO.getManufacturer_id()));
        carRepository.save(carEntity);
    }

    public List<CarDTO> getAllCar() {
        List<CarDTO> carDTOList = new ArrayList<>();
        for (CarEntity carEntity : carRepository.findAll()) {
            carDTOList.add(
                    new CarDTO(
                            carEntity.getId(),
                            carEntity.getName(),
                            carEntity.getColor(),
                            carEntity.getAvailable(),
                            carEntity.getManufacturerEntity().getId())
            );
        }
        return carDTOList;
    }
}
