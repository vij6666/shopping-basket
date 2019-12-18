package kata.supermarket;

import java.math.BigDecimal;

public interface IProduct {
   String getProductDescription();
   BigDecimal getPrice();
   DiscountStrategy getDiscountStrategy();
}
