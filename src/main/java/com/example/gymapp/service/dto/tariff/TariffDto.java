package com.example.gymapp.service.dto.tariff;

import com.example.gymapp.dao.entity.Tariff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TariffDto {
    Integer id;
    BigDecimal price;
    String title;
    String description;
    Integer months;


    public static List<TariffDto> fromTariffList(List<Tariff> tariffs){
        return tariffs.stream().map( tariff -> {
            return TariffDto.builder()
                    .id(tariff.getId())
                    .description(tariff.getDescription())
                    .title(tariff.getTitle())
                    .price(tariff.getPrice())
                    .months(tariff.getDuration().getMonths())
                    .build();
        }).collect(Collectors.toList());
    }
}
