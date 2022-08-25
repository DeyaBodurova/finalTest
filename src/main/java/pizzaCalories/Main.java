package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pizzaData = sc.nextLine().split("\\s+");
        Pizza pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
        String[] doughData = sc.nextLine().split("\\s+");
        Dough dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));
        pizza.setDough(dough);
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("END")) {
            String[] toppingData = input.split("\\s+");
            Topping topping = new Topping(toppingData[1], Double.parseDouble(toppingData[2]));
            pizza.addTopping(topping);
            input = sc.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
