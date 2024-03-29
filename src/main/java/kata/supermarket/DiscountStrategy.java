package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountStrategy {

    BigDecimal calculateDiscount(IProduct product, BigDecimal numberOfItems);

}
