package Person1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Birthable> creatures = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String type = data[0];
            switch (type) {
                case "Citizen":
                    Citizen citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    creatures.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(data[1], data[2]);
                    creatures.add(pet);
                    break;
                case "Robot":
                    Robot robot = new Robot(data[1], data[2]);
                    break;
            }
            input = sc.nextLine();
        }
        String year = sc.nextLine();
        for (Birthable birthable : creatures) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
