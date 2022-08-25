package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType == null || toppingType.trim().isEmpty() || ((!toppingType.equalsIgnoreCase("meat"))
                && (!toppingType.equalsIgnoreCase("veggies")) && (!toppingType.equalsIgnoreCase("cheese"))
                && (!toppingType.equalsIgnoreCase("sauce")))) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight) * getToppingTypeModifier(toppingType);
    }

    private double getToppingTypeModifier(String toppingType) {
        toppingType = toppingType.toLowerCase();
        switch (toppingType) {
            case "meat":
                return 1.2;
            case "veggies":
                return 0.8;
            case "cheese":
                return 1.1;
            case "sauce":
                return 0.9;
            default:
                return 0;
        }
    }
}
