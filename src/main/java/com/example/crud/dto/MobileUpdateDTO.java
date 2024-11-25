package com.example.crud.dto;



import java.math.BigDecimal;

public record MobileUpdateDTO(String manufacturer,
                              String ram,
                              String memory,
                              String battery,
                              String processor,
                              BigDecimal price) {
}
