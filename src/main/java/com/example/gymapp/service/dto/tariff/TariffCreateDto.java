package com.example.gymapp.service.dto.tariff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TariffCreateDto {
    private String title;
    private String description;
    private BigDecimal price;
    private Integer duration;
}
