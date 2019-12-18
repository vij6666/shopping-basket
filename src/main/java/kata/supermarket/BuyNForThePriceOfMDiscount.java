package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyNForThePriceOfMDiscount implements DiscountStrategy {

    private final int numberOfItemsRequired;
    private final int numberOfItemsYouPayFor;


    public BuyNForThePriceOfMDiscount(final int numberOfItemsRequired, final int numberOfItemsYouPayFor){
        this.numberOfItemsRequired = numberOfItemsRequired;
        this.numberOfItemsYouPayFor = numberOfItemsYouPayFor;
    }

    @Override
    public BigDecimal calculateDiscount(IProduct product, BigDecimal numberOfItems) {

        BigDecimal numberOfDiscounts = numberOfItems.divide(new BigDecimal((numberOfItemsRequired)), RoundingMode.DOWN);
        BigDecimal remainder = numberOfItems.remainder(new BigDecimal((numberOfItemsRequired)));
        BigDecimal priceToPay = product.getPrice().multiply(((new BigDecimal(numberOfItemsYouPayFor)).multiply(numberOfDiscounts)).add(remainder));
        BigDecimal priceYouShouldHavePaid = product.getPrice().multiply(numberOfItems);

        return priceYouShouldHavePaid.subtract(priceToPay).setScale(2);
    }
}
