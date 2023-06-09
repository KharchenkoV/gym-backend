package com.example.gymapp.service.impl;

import com.example.gymapp.dao.entity.Exercise;
import com.example.gymapp.dao.enums.BodyPart;
import com.example.gymapp.dao.enums.Equipment;
import com.example.gymapp.dao.enums.Target;
import com.example.gymapp.dao.repository.ExerciseRepository;
import com.example.gymapp.service.api.ExerciseService;
import com.example.gymapp.service.dto.exercise.ExerciseCreateDto;
import com.example.gymapp.service.dto.exercise.ExerciseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    @Override
    public void createExercises(List<ExerciseCreateDto> exerciseList) {
        exerciseList.forEach(ex -> {
            try{
                Exercise exercise = Exercise.builder()
                        .name(ex.getName())
                        .bodyPart(BodyPart.valueOf(validate(ex.getBodyPart())))
                        .equipment(Equipment.valueOf(validate(ex.getEquipment())))
                        .target(Target.valueOf(validate(ex.getTarget())))
                        .gifUrl(ex.getGifUrl())
                        .build();
                exerciseRepository.save(exercise);
            } catch (Exception ignore) {}
        });
    }

    @Override
    public List<ExerciseDto> getExercises() {
        return ExerciseDto.fromExerciseList(exerciseRepository.findAll());
    }

    @Override
    public List<ExerciseDto> getExercisesByBodyPart(String bodyPart) {
        BodyPart bp;
        try{
            bp = BodyPart.valueOf(bodyPart.toUpperCase());
        } catch (Exception exception){
            throw new RuntimeException("Body Part doesn't exist with name: " + bodyPart);
        }
        return ExerciseDto.fromExerciseList(exerciseRepository.findExercisesByBodyPart(bp));
    }

    @Override
    public List<ExerciseDto> getExercisesByTarget(String target) {
        Target target1;
        try{
            target1 = Target.valueOf(target.toUpperCase());
        } catch (Exception exception){
            throw new RuntimeException("Target doesn't exist with name: " + target);
        }
        return ExerciseDto.fromExerciseList(exerciseRepository.findExercisesByTarget(target1));
    }

    @Override
    public List<ExerciseDto> getExercisesByEquipment(String equipment) {
        Equipment equipment1;
        try{
            equipment1 = Equipment.valueOf(equipment.toUpperCase());
        } catch (Exception exception){
            throw new RuntimeException("Equipment doesn't exist with name: " + equipment);
        }
        return ExerciseDto.fromExerciseList(exerciseRepository.findExercisesByEquipment(equipment1));
    }

    @Override
    public ExerciseDto getExerciseById(Integer exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise is not found with id: " + exerciseId));
        return ExerciseDto.fromExercise(exercise);
    }

    private String validate(String name){
        return name.toUpperCase().replace(' ', '_');
    }
}
