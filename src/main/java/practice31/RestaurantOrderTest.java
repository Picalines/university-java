package practice31;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RestaurantOrderTest {
    @Test
    public void emptyOrderResults() {
        var order = new RestaurantOrder();

        assertEquals(0, order.size());
        assertTrue(order.toArray().isEmpty());
        assertEquals(0, order.itemNames().length);
        assertEquals(0, order.totalCost(), 0.0);
    }

    @Test
    public void sizeIncreaseAfterAdd() {
        var order = new RestaurantOrder();

        assertEquals(0, order.size());
        order.add(new Dish(1, "dish", "desc"));
        assertEquals(1, order.size());
    }

    @Test
    public void sizeDecreaseAfterRemove() {
        var order = new RestaurantOrder();

        order.add(new Dish(1, "dish", "desc"));
        assertEquals(1, order.size());
        order.remove("dish");
        assertEquals(0, order.size());
    }
}
