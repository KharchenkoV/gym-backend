package com.example.gymapp.core.controller;

import com.example.gymapp.service.api.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/subscription")
@CrossOrigin
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    @PostMapping("/{id}/create")
    public ResponseEntity<HttpStatus> makeSubscription(@PathVariable(name = "id") Integer tariffId, Principal principal){
        subscriptionService.makeSubscription(tariffId, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
