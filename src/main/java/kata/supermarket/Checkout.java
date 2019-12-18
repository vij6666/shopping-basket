package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Checkout {

    private final Basket basket;

    public Checkout(final Basket basket){
        this.basket = basket;
    }

    public BigDecimal calculateSubtotal(){
        return basket.items().entrySet().stream()
                .map(e -> e.getKey().getPrice().multiply(e.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public void checkout(Basket basket){
        // Calculate totals
        // Arrange and validate payment details
        }

    public BigDecimal calculateVAT(BigDecimal total){
        return total.multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateDiscounts(){
        Map<IProduct,BigDecimal> items = basket.items();
        BigDecimal discount = BigDecimal.ZERO;

        for (IProduct product : items.keySet()){
            DiscountStrategy discountStrategy = product.getDiscountStrategy();
            discount =  discount.add(discountStrategy.calculateDiscount(product, items.get(product)));
        }
        return discount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculatePreTaxTotal(){
        return calculateSubtotal().subtract(calculateDiscounts());
    }

    public BigDecimal calculatePostTaxTotal() {
        return calculatePreTaxTotal().add(calculateVAT(calculatePreTaxTotal())).setScale(2, RoundingMode.HALF_UP);
    }

}
