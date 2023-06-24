package com.example.gymapp.core.controller;

import com.example.gymapp.service.api.TariffService;
import com.example.gymapp.service.dto.tariff.TariffCreateDto;
import com.example.gymapp.service.dto.tariff.TariffDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tariff")
@CrossOrigin
@RequiredArgsConstructor
public class TariffController {
    private final TariffService tariffService;
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createTariff(@RequestBody TariffCreateDto createDto){
        tariffService.createTariff(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<TariffDto>> getAllTariffs(){
        return ResponseEntity.ok(tariffService.getTariffs());
    }
}
