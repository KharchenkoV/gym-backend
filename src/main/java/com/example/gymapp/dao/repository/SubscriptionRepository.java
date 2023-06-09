package com.example.gymapp.dao.repository;

import com.example.gymapp.dao.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
