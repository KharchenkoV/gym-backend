package com.example.gymapp.service.impl;

import com.example.gymapp.dao.entity.Tariff;
import com.example.gymapp.dao.repository.TariffRepository;
import com.example.gymapp.service.api.TariffService;
import com.example.gymapp.service.dto.tariff.TariffCreateDto;
import com.example.gymapp.service.dto.tariff.TariffDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepository;
    @Override
    public void createTariff(TariffCreateDto createDto) {
        Tariff tariff = Tariff.builder()
                .title(createDto.getTitle())
                .description(createDto.getDescription())
                .duration(Period.ofMonths(createDto.getDuration()))
                .price(createDto.getPrice())
                .build();
        tariffRepository.save(tariff);
    }

    @Override
    public List<TariffDto> getTariffs() {
        List<Tariff> tariffs = tariffRepository.findAll();
        return TariffDto.fromTariffList(tariffs);
    }
}
