package restaurant;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {
    private String name;
    private BigDecimal price;
    private double milliliters;

    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
