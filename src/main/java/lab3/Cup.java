package lab3;

public class Cup extends Dish {
    public Cup() {
        super("cup");
    }

    @Override
    protected void washInternal() {
        System.out.println("a cup is being washed");
    }
}
