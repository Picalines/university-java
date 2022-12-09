package practice30;

public enum DrinkType {
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
