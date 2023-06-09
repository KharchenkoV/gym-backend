package com.example.gymapp.dao.repository;

import com.example.gymapp.dao.entity.Exercise;
import com.example.gymapp.dao.enums.BodyPart;
import com.example.gymapp.dao.enums.Equipment;
import com.example.gymapp.dao.enums.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    List<Exercise> findExercisesByBodyPart(BodyPart bodyPart);
    List<Exercise> findExercisesByTarget(Target target);
    List<Exercise> findExercisesByEquipment(Equipment equipment);
}
