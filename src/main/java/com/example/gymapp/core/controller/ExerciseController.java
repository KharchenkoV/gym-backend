package com.example.gymapp.core.controller;

import com.example.gymapp.service.api.ExerciseService;
import com.example.gymapp.service.dto.exercise.ExerciseCreateDto;
import com.example.gymapp.service.dto.exercise.ExerciseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercise")
@CrossOrigin
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;
    @GetMapping
    public ResponseEntity<List<ExerciseDto>> getExercises(){
        return ResponseEntity.ok(exerciseService.getExercises());
    }
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createExercises(@RequestBody List<ExerciseCreateDto> exerciseList){
        exerciseService.createExercises(exerciseList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDto> getExerciseById(@PathVariable Integer id){
        return ResponseEntity.ok(exerciseService.getExerciseById(id));
    }

    @GetMapping("/bodypart/{bodyPart}")
    public ResponseEntity<List<ExerciseDto>> getExercisesByBodyPart(@PathVariable String bodyPart){
        return ResponseEntity.ok(exerciseService.getExercisesByBodyPart(bodyPart));
    }
    @GetMapping("/target/{target}")
    public ResponseEntity<List<ExerciseDto>> getExercisesByTarget(@PathVariable String target){
        return ResponseEntity.ok(exerciseService.getExercisesByTarget(target));
    }
    @GetMapping("/equipment/{equipment}")
    public ResponseEntity<List<ExerciseDto>> getExercisesByEquipment(@PathVariable String equipment){
        return ResponseEntity.ok(exerciseService.getExercisesByEquipment(equipment));
    }
}
