package ZooApp.core;

import ZooApp.entities.animals.AquaticAnimal;
import ZooApp.entities.animals.Animal;
import ZooApp.entities.animals.TerrestrialAnimal;
import ZooApp.entities.areas.Area;
import ZooApp.entities.areas.LandArea;
import ZooApp.entities.areas.WaterArea;
import ZooApp.entities.foods.Food;
import ZooApp.entities.foods.Meat;
import ZooApp.entities.foods.Vegetable;
import ZooApp.repositories.FoodRepository;
import ZooApp.repositories.FoodRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static ZooApp.common.ConstantMessages.*;
import static ZooApp.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.put(areaName, area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        Area area = areas.get(areaName);
        area.addFood(food);
        foodRepository.remove(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        Area area = areas.get(areaName);
        String areaType = area.getClass().getSimpleName();
        boolean landAreaAndAnimal = animalType.equals("TerrestrialAnimal") && areaType.equals("LandArea");
        boolean waterAreaAndAnimal = animalType.equals("AquaticAnimal") && areaType.equals("WaterArea");
        if (landAreaAndAnimal || waterAreaAndAnimal) {
            area.addAnimal(animal);
        } else {
            return AREA_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = areas.get(areaName);
        area.feed();
        return String.format(ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.get(areaName);
        double totalKg = area.getAnimals()
                .stream()
                .mapToDouble(Animal::getKg)
                .sum();
        return String.format(KILOGRAMS_AREA, areaName, totalKg);
    }

    @Override
    public String getStatistics() {
        return areas.values().stream().map(Area::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}