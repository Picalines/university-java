package practice32;

import java.io.Serializable;

public enum DrinkType implements Serializable {
    BEER(true),
    VODKA(true),
    WINE(true),
    BRANDY(true),
    TEQUILA(true),
    RUM(true),
    WHISKEY(true),
    LIQUOR(true),
    JUICE(false),
    COFFEE(false),
    TEA(false),
    MILK(false),
    WATER(false);

    private final boolean isAlcohol;

    DrinkType(boolean isAlcohol) {
        this.isAlcohol = isAlcohol;
    }

    public boolean isAlcohol() {
        return isAlcohol;
    }
}
