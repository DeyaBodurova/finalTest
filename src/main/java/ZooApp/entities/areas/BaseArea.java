package ZooApp.entities.areas;

import ZooApp.entities.animals.Animal;
import ZooApp.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static ZooApp.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static ZooApp.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    public void addAnimal(Animal animal) {
        if(animals.size() == capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void addFood(Food food) {
        foods.add(food);
    }
    public void feed() {
        animals.forEach(Animal::eat);
    }

    public String getInfo() {
        String animalOutput = animals.isEmpty()
                ? "none"
                : animals.stream()
                .map(Animal::getName)
                .collect(Collectors.joining(" "));

        return String.format("%s (%s):%n" +
                "Animals: %s%n" +
                "Foods: %d%n" +
                "Calories: %d", name, this.getClass().getSimpleName(), animalOutput, foods.size(), sumCalories());
    }

    public String getName() {
        return name;
    }

    public Collection<Food> getFoods() {
        return foods;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFoods(Collection<Food> foods) {
        this.foods = foods;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }
}