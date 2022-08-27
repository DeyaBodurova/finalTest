package shoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] peopleData = sc.nextLine().split(";");
        for (int i = 0; i < peopleData.length; i++) {
            String[] currentPerson = peopleData[i].split("=");
            String currentPersonName = currentPerson[0];
            double currentPersonMoney = Double.parseDouble(currentPerson[1]);
            try {
                Person person = new Person(currentPersonName, currentPersonMoney);
                people.put(currentPersonName, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productsData = sc.nextLine().split(";");
        for (int i = 0; i < productsData.length; i++) {
            String[] currentProduct = productsData[i].split("=");
            String currentProductName = currentProduct[0];
            double currentProductCost = Double.parseDouble(currentProduct[1]);
            try {
                Product product = new Product(currentProductName, currentProductCost);
                products.put(currentProductName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = sc.nextLine();
        while(!input.equals("END")) {
            String[] purchaseData = input.split(" ");
            Person buyer = people.get(purchaseData[0]);
            Product productToBuy = products.get(productsData[1]);
            try {
                buyer.buyProduct(productToBuy);
                System.out.printf("%s bought %s%n", peopleData[0], purchaseData[1]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = sc.nextLine();
        }
        people.values().forEach(System.out::println);
    }
}
