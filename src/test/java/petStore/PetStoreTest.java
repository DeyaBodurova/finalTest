package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTest {
    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal = new Animal("Wolf", 30, 150.5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getAnimals_shouldReturnUnmodifiableList() {
        List<Animal> animals = petStore.getAnimals();
        animals.add(new Animal("Lion",400,1000));
    }

    @Test
    public void getCount() {
        petStore.addAnimal(animal);
        int count = petStore.getCount();
        assertEquals(1,count);
    }

    @Test
    public void getCount_shouldReturnZero() {
        int count = petStore.getCount();
        assertEquals(0,count);
    }

    @Test
    public void findAllAnimalsWithMaxKilograms() {
        petStore.addAnimal(new Animal("mouse",1, 1000));
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(5);
        assertEquals(1,animals.size());
        assertEquals(30,animals.get(0).getMaxKilograms());
    }

    @Test
    public void addAnimal() {
        petStore.addAnimal(animal);
        assertEquals(1,petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAnimal_shouldThrowException() {
        petStore.addAnimal(null);
    }

    @Test
    public void getTheMostExpensiveAnimal() {
        Animal animal2 = new Animal("cat", 10, 20);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);
        Animal actualAnimal = petStore.getTheMostExpensiveAnimal();
        assertEquals(animal.getPrice(), actualAnimal.getPrice(), 0.0);
    }

    @Test
    public void getTheMostExpensiveAnimal_shouldReturn_Null() {
        Animal animal = petStore.getTheMostExpensiveAnimal();
        assertNull(animal);
    }

    @Test
    public void findAllAnimalBySpecie() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Cat", 5, 150));
        List<Animal> animals = petStore.findAllAnimalBySpecie("Wolf");
        assertEquals(1, animals.size());
        assertEquals("Wolf", animals.get(0).getSpecie());
    }

    @Test
    public void findAllAnimalBySpecie_whenThereAreNoAnimals() {
        List<Animal> animals = petStore.findAllAnimalBySpecie("Wolf");
        assertTrue(animals.isEmpty());
    }
}