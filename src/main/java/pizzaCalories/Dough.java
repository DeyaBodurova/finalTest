package pizzaCalories;
public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType == null || flourType.trim().isEmpty() || ((!flourType.equalsIgnoreCase("white"))
                && (!flourType.equalsIgnoreCase("wholegrain")))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique == null || bakingTechnique.trim().isEmpty() ||
                ((!bakingTechnique.equalsIgnoreCase("crispy"))
                        && (!bakingTechnique.equalsIgnoreCase("chewy"))
                        && (!bakingTechnique.equalsIgnoreCase("homemade")))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }


    public double calculateCalories() {
        return (2 * weight) * getFlourTypeModifier(flourType) * getBakingTechniqueModifier(bakingTechnique);
    }

    private double getBakingTechniqueModifier(String bakingTechnique) {
        bakingTechnique = bakingTechnique.toLowerCase();
        switch (bakingTechnique) {
            case "crispy":
                return 0.9;
            case "chewy":
                return 1.1;
            case "homemade":
                return 1.0;
            default:
                return 0;
        }
    }

    private double getFlourTypeModifier(String flourType) {
        flourType = flourType.toLowerCase();
        switch (flourType) {
            case "white":
                return 1.5;
            case "wholegrain":
                return 1.0;
            default:
                return 0;
        }
    }
}
