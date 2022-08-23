package cards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardRanks cardRanks = CardRanks.valueOf(sc.nextLine());
        Suits suits = Suits.valueOf(sc.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d",
                cardRanks, suits, cardRanks.getRankPower() + suits.getSuitsPower());
    }
}
