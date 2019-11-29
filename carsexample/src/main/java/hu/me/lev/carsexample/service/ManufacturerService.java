package hu.me.lev.carsexample.service;

import hu.me.lev.carsexample.persist.ManufacturerEntity;
import hu.me.lev.carsexample.persist.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public void addManufacturer(ManufacturerEntity manufacturerEntity) {
        manufacturerRepository.save(manufacturerEntity);
    }

    public List<ManufacturerEntity> getManufacturers() {
        return (List<ManufacturerEntity>) manufacturerRepository.findAll();
    }

    public ManufacturerEntity getManufacturer(Long id) {
        return manufacturerRepository.findById(id).get();
    }
}
