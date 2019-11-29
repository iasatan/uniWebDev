package hu.me.lev.carsexample.persist;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarEntity, Long> {
}
