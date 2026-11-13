package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @PostConstruct
    public void loadAll() {
        animals.put(1, new Animal(1, "maymun"));
    }

    @GetMapping
    public List<Animal> findAll() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Integer id, @RequestBody Animal animal) {
        animals.put(id, new Animal(id, animal.getName()));
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable Integer id) {
        return animals.remove(id);
    }
}
