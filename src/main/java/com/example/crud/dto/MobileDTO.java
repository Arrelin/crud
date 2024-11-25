package com.example.crud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>Main Entity but in safer way</p>
 * @param id
 * @param manufacturer
 * @param ram
 * @param memory
 * @param battery
 * @param processor
 * @param price
 * @param createdAt
 */
public record MobileDTO(Long id,
                        String manufacturer,
                        String ram,
                        String memory,
                        String battery,
                        String processor,
                        BigDecimal price,
                        LocalDate createdAt) {

}
