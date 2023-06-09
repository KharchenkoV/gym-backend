package com.example.gymapp.service.impl;

import com.example.gymapp.dao.entity.Subscription;
import com.example.gymapp.dao.entity.Tariff;
import com.example.gymapp.dao.entity.User;
import com.example.gymapp.dao.repository.SubscriptionRepository;
import com.example.gymapp.dao.repository.TariffRepository;
import com.example.gymapp.service.api.SubscriptionService;
import com.example.gymapp.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final UserService userService;
    private final TariffRepository tariffRepository;
    private final SubscriptionRepository subscriptionRepository;
    @Override
    public void makeSubscription(Integer tariffId, String email) {
        User user = userService.getUserByEmail(email);
        Tariff tariff = loadTariffById(tariffId);
        Subscription subscription = Subscription.builder()
                .user(user)
                .tariff(tariff)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plus(tariff.getDuration()))
                .expired(false)
                .build();
        subscriptionRepository.save(subscription);
    }

    private Tariff loadTariffById(Integer id){
        return tariffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tariff is not found with id: " + id));
    }

}
