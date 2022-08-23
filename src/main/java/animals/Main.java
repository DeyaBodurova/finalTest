package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("Beast")) {
            String[] animalData = sc.nextLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];
            System.out.println(input);
            switch (input) {
                case "Cat":
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat);
                    break;
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog);
                    break;
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat);
                    break;
            }
            input = sc.nextLine();
        }

    }
}
