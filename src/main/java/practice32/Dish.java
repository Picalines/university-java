package practice32;

import java.io.Serializable;

public final class Dish extends MenuItem implements Serializable {
    public Dish(String name, String description, int cost){
        super(name, description, cost);
    }
}
