package com.xworkz.railways.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class RailwayDTO {
    public RailwayDTO(){
        System.out.println("Railway DTO loaded");
    }
    private Integer railwayId;
    @Size(min = 2, max = 30)
    private String name;
    @Size(min = 2, max = 30)
    private String email;
    @Min(18)
    private Integer age;
    private LocalDate date;
    @Size(min = 2, max = 30)
    private String source;
    @Size(min = 2, max = 30)
    private String destination;
}
