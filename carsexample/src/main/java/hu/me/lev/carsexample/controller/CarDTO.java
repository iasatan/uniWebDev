package hu.me.lev.carsexample.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class CarDTO {
    @Min(0)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String color;
    @Min(0)
    private Integer available;
    @Min(0)
    private Long manufacturer_id;


}
