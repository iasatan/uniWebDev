package hu.me.lev.carsexample.persist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "car")
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {

    @Id
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String color;
    @Min(0)
    private Integer available;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerEntity manufacturerEntity;
}
