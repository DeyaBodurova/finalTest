package TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> colours  = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        int changeTrafficLights = Integer.parseInt(sc.nextLine());
        List<TrafficLight> trafficLights = new ArrayList<>();
        for (String colour:colours) {
            Colours currentColour = Colours.valueOf(colour);
            TrafficLight currentTrafficLight = new TrafficLight(currentColour);
            trafficLights.add(currentTrafficLight);
        }
        for (int i = 0; i < changeTrafficLights; i++) {
            for (TrafficLight trafficLight:trafficLights) {
                trafficLight.changeColour();
                System.out.print(trafficLight.getCurrentColour() + " ");
            }
            System.out.println();
        }
    }
}
