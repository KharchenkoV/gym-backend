package com.example.gymapp.service.api;

import com.example.gymapp.service.dto.tariff.TariffCreateDto;

public interface TariffService {
    void createTariff(TariffCreateDto createDto);
}
