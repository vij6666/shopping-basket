package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product("Baked Beans", price, new NoDiscount()).oneOf().price());

    }

    @Test
    void singleItemHasExpectedProductDescriptionFromProduct() {
        final BigDecimal price = new BigDecimal("1.00");
        String prodDesc = "Baked Beans";
        assertEquals(prodDesc, new Product("Baked Beans", price, new NoDiscount()).getProductDescription());

    }

    @Test
    void singelItemHasExpectedDiscountStrategyProduct() {
        final BigDecimal price = new BigDecimal("1.00");
        NoDiscount noDiscount = new NoDiscount();
        String prodDesc = "Baked Beans";
        assertEquals(noDiscount, new WeighedProduct(prodDesc, price, noDiscount).getDiscountStrategy());

    }

}