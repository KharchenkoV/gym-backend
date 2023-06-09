package com.example.gymapp.service.impl;

import com.example.gymapp.dao.entity.Tariff;
import com.example.gymapp.dao.repository.TariffRepository;
import com.example.gymapp.service.api.TariffService;
import com.example.gymapp.service.dto.tariff.TariffCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Period;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepository;
    @Override
    public void createTariff(TariffCreateDto createDto) {
        Tariff tariff = Tariff.builder()
                .title(createDto.getTitle())
                .duration(Period.ofMonths(createDto.getDuration()))
                .price(createDto.getPrice())
                .build();
        tariffRepository.save(tariff);
    }
}
