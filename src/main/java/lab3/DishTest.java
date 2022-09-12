package lab3;

public class DishTest {
    public static void main(String[] args) {
        var bowl = new Bowl();
        var cup = new Cup();

        System.out.println(bowl);
        System.out.println(cup);

        bowl.wash();
        cup.wash();

        bowl.destroy();
        System.out.println(bowl);
        try {
            bowl.wash();
        }
        catch (IllegalStateException e) {
            System.out.println("IllegalStateException was thrown by Dish.wash");
        }
    }
}
