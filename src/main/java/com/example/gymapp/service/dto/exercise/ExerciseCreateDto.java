package com.example.gymapp.service.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseCreateDto {
    private String name;
    private String bodyPart;
    private String equipment;
    private String gifUrl;
    private String target;
}
