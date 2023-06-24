package com.example.gymapp.service.api;

import com.example.gymapp.service.dto.tariff.TariffCreateDto;
import com.example.gymapp.service.dto.tariff.TariffDto;

import java.util.List;

public interface TariffService {
    void createTariff(TariffCreateDto createDto);
    List<TariffDto> getTariffs();
}
