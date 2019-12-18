package kata.supermarket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeighedProductTest {

    @ParameterizedTest
    @MethodSource
    void itemFromWeighedProductHasExpectedUnitPrice(String productDescription, String pricePerKilo, String weightInKilos, String expectedPrice) {
        final WeighedProduct weighedProduct = new WeighedProduct(productDescription, new BigDecimal(pricePerKilo), new NoDiscount());
        final Item weighedItem = weighedProduct.weighing(new BigDecimal(weightInKilos));
        assertEquals(new BigDecimal(expectedPrice), weighedItem.price());
    }

    static Stream<Arguments> itemFromWeighedProductHasExpectedUnitPrice() {
        return Stream.of(
                Arguments.of("Gold","100.00", "1.00", "100.00"),
                Arguments.of("Frankincense", "100.00", "0.33333", "33.33"),
                Arguments.of("Myrrh", "100.00", "0.33335", "33.34"),
                Arguments.of("Chocolate", "100.00", "0", "0.00")
        );
    }

    @Test
    void itemHasExpectedProductDescriptionFromProduct() {
        final BigDecimal price = new BigDecimal("1.00");
        String prodDesc = "Pick And Mix";
        assertEquals(prodDesc, new WeighedProduct(prodDesc, price, new NoDiscount()).getProductDescription());

    }

    @Test
    void itemHasExpectedDiscountStrategyProduct() {
        final BigDecimal price = new BigDecimal("1.00");
        NoDiscount noDiscount = new NoDiscount();
        String prodDesc = "Pick And Mix";
        assertEquals(noDiscount, new WeighedProduct(prodDesc, price, noDiscount).getDiscountStrategy());

    }

}