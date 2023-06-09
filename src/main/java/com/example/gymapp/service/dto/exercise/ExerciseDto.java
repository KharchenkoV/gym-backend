package com.example.gymapp.service.dto.exercise;

import com.example.gymapp.dao.entity.Exercise;
import com.example.gymapp.dao.enums.BodyPart;
import com.example.gymapp.dao.enums.Equipment;
import com.example.gymapp.dao.enums.Target;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseDto {
    private Integer id;
    private String name;
    private String gifUrl;
    private BodyPart bodyPart;
    private Target target;
    private Equipment equipment;
    public static List<ExerciseDto> fromExerciseList(List<Exercise> exercises){
        return exercises.stream().map( exercise -> {
                return ExerciseDto.builder()
                        .id(exercise.getId())
                        .name(exercise.getName())
                        .gifUrl(exercise.getGifUrl())
                        .bodyPart(exercise.getBodyPart())
                        .target(exercise.getTarget())
                        .equipment(exercise.getEquipment())
                .build();
        }).collect(Collectors.toList());
    }
    public static ExerciseDto fromExercise(Exercise exercise){
        return ExerciseDto.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .gifUrl(exercise.getGifUrl())
                .bodyPart(exercise.getBodyPart())
                .target(exercise.getTarget())
                .equipment(exercise.getEquipment())
                .build();
    }
}
