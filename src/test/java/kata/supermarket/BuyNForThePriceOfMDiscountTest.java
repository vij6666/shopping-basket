package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyNForThePriceOfMDiscountTest {

    @Test
    public void testApplyDiscountGiven() {

        DiscountStrategy buyOneGetOneFree = new BuyNForThePriceOfMDiscount(2,1);
        IProduct product = new Product("Baked Beans", new BigDecimal(1.50).setScale(2), buyOneGetOneFree);
        BigDecimal numberOfItems = new BigDecimal(73);
        BuyNForThePriceOfMDiscount buyNForThePriceOfMDiscount = new BuyNForThePriceOfMDiscount(2,1);
        assertEquals(new BigDecimal(54.00).setScale(2), buyNForThePriceOfMDiscount.calculateDiscount(product, numberOfItems));
    }

    @Test
    public void testApplyDiscountGivenBuy3For2() {

        DiscountStrategy buyThreeForTwo = new BuyNForThePriceOfMDiscount(3,2);
        IProduct product = new Product("Baked Beans", new BigDecimal(1.50).setScale(2), buyThreeForTwo);
        BigDecimal numberOfItems = new BigDecimal(11);
        BuyNForThePriceOfMDiscount buyNForThePriceOfMDiscount = new BuyNForThePriceOfMDiscount(3,2);
        assertEquals(new BigDecimal(4.50).setScale(2), buyNForThePriceOfMDiscount.calculateDiscount(product, numberOfItems));
    }
}
