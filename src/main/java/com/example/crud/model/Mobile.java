package com.example.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Long id;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "ram")
    private String ram;

    @Column(name = "memory")
    private String memory;

    @Column(name = "battery")
    private String battery;

    @Column(name = "processor")
    private String processor;

    @Column(name = "price")
    private BigDecimal price;
}
