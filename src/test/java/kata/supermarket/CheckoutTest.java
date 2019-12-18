package kata.supermarket;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CheckoutTest {

    @Test
    public void testCalculateVAT(){
        BigDecimal total = new BigDecimal(1);
        Checkout checkout = new Checkout(new Basket());
        assertEquals(new BigDecimal(0.20).setScale(2, RoundingMode.HALF_UP), checkout.calculateVAT(total));
    }

    @Test
    public void testCalculateSubtotal(){

        Basket basket = new Basket();
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.5), new NoDiscount())));
        basket.add(new ItemByWeight(new WeighedProduct("Pick And Mix", new BigDecimal(2), new NoDiscount()), new BigDecimal(1)));
        Checkout checkout = new Checkout(basket);
        BigDecimal expectedValue = new BigDecimal(3.50).setScale(2);
        assertEquals(expectedValue, checkout.calculateSubtotal());

    }

    @Test
    public void testCalculatePreTaxTotal(){

        Basket basket = new Basket();
        DiscountStrategy discountStrategy = new BuyNForThePriceOfMDiscount(2,1);
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.5), discountStrategy)));
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.5), discountStrategy)));
        Checkout checkout = new Checkout(basket);
        BigDecimal expectedValue = new BigDecimal(1.50).setScale(2);
        assertEquals(expectedValue, checkout.calculatePreTaxTotal());

    }

    @Test
    public void testCalculatePostTaxTotal(){

        Basket basket = new Basket();
        DiscountStrategy discountStrategy = new BuyNForThePriceOfMDiscount(2,1);
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.5), discountStrategy)));
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.5), discountStrategy)));
        Checkout checkout = new Checkout(basket);
        BigDecimal expectedValue = new BigDecimal(1.8).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue, checkout.calculatePostTaxTotal());

    }

    @Test
    public void testCalculateDiscountsBuyOneGetOneFree(){
        Basket basket = new Basket();
        // Buy One Get One free
        BuyNForThePriceOfMDiscount discountStrategy = new BuyNForThePriceOfMDiscount(2,1);
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.50), discountStrategy)));
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.50), discountStrategy)));
        Checkout checkout = new Checkout(basket);
        BigDecimal expectedValue = new BigDecimal(1.50).setScale(2);
        assertEquals(expectedValue, checkout.calculateDiscounts());

    }

    @Test
    public void testCalculateDiscountsBuyThreeForTwo(){
        Basket basket = new Basket();
        // Buy One Get One free
        BuyNForThePriceOfMDiscount discountStrategy = new BuyNForThePriceOfMDiscount(3,2);
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.50), discountStrategy)));
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.50), discountStrategy)));
        basket.add(new ItemByUnit(new Product("Baked Beans", new BigDecimal(1.50), discountStrategy)));
        Checkout checkout = new Checkout(basket);
        BigDecimal expectedValue = new BigDecimal(1.50).setScale(2);
        assertEquals(expectedValue, checkout.calculateDiscounts());

    }

}
