package com.example.gymapp.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity
public class Tariff {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private BigDecimal price;
    private Period duration;
}
