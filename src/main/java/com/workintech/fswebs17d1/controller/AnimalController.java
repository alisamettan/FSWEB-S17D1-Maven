package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/workintech/animal")
@RestController
public class AnimalController {
    private Map<Integer, Animal> animals=new HashMap<>();

    @Value("${project.developer.fullname}")
    private String fullName;

    @Value("${course.name}")
    private String courseName;




    @GetMapping()
    public List<Animal> getAnimals(){
       return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id){
        return this.animals.get(id);
    }

    @PostMapping()
    public Animal save(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable int id,@RequestBody Animal animal){
        animals.put(id,new Animal(id,animal.getName()));//animals.replace(id,animal)
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id){
        Animal animal=animals.get(id);
        animals.remove(id,animal);
        return animal;
    }


}
