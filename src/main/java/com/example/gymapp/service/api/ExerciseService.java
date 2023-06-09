package com.example.gymapp.service.api;

import com.example.gymapp.service.dto.exercise.ExerciseCreateDto;
import com.example.gymapp.service.dto.exercise.ExerciseDto;

import java.util.List;

public interface ExerciseService {
    void createExercises(List<ExerciseCreateDto> exerciseList);
    List<ExerciseDto> getExercises();
    List<ExerciseDto> getExercisesByBodyPart(String bodyPart);
    List<ExerciseDto> getExercisesByTarget(String target);
    List<ExerciseDto> getExercisesByEquipment(String equipment);
    ExerciseDto getExerciseById(Integer exerciseId);
}
