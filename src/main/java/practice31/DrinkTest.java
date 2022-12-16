package practice31;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class DrinkTest {
    @Test
    public void shouldThrowOnNegativeCost() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Drink(-1, "normal name", "normal desc");
        });
    }

    @Test
    public void shouldThrowOnEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Drink(1, "", "normal desc");
        });
    }

    @Test
    public void shouldThrowOnEmptyDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Drink(1, "normal name", "");
        });
    }
}
