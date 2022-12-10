package practice32;

import java.io.Serializable;

public final class Drink extends MenuItem implements Alcoholable, Serializable {
    private final DrinkType type;
    private final double alcoholVol;

    public Drink(String name, String description, int cost, DrinkType type, double alcoholVol) {
        super(name, description, cost);
        this.type = type;
        this.alcoholVol = alcoholVol;
    }

    public DrinkType getType() {
        return type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return type.isAlcohol();
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }
}
