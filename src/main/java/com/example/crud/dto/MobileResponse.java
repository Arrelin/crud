package com.example.crud.dto;

import java.math.BigDecimal;

public record MobileResponse(Long id, String manufacturer, String ram, String memory, String battery, String processor, BigDecimal price) {
}
