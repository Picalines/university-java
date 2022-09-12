package lab3;

public class Bowl extends Dish {
    public Bowl() {
        super("bowl");
    }

    @Override
    protected void washInternal() {
        System.out.println("a bowl is being washed");
    }
}
