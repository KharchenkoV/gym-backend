package com.example.gymapp.dao.entity;

import com.example.gymapp.dao.enums.BodyPart;
import com.example.gymapp.dao.enums.Equipment;
import com.example.gymapp.dao.enums.Target;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String gifUrl;
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;
    @Enumerated(EnumType.STRING)
    private Equipment equipment;
    @Enumerated(EnumType.STRING)
    private Target target;
}
