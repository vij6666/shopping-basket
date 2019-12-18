package kata.supermarket;

import java.math.BigDecimal;

public class NoDiscount implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(IProduct product, BigDecimal numberOfItems) {
        // Return zero as there is no discount
        return BigDecimal.ZERO;
    }
}
