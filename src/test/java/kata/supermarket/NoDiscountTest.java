package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoDiscountTest {

    @Test
    public void testNoDiscountGiven() {

        IProduct product = new Product("Baked Beans", new BigDecimal(1.50).setScale(2), new NoDiscount());
        BigDecimal numberOfItems = new BigDecimal(73);
        NoDiscount noDiscount = new NoDiscount();
        assertEquals(BigDecimal.ZERO, noDiscount.calculateDiscount(product, numberOfItems));
    }
}
