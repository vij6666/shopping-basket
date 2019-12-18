package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct implements IProduct {

    private final BigDecimal pricePerKilo;
    private final String productDescription;
    private final DiscountStrategy discountStrategy;

    public WeighedProduct(final String productDescription, final BigDecimal pricePerKilo, final DiscountStrategy discountStrategy) {
        this.productDescription = productDescription;
        this.pricePerKilo = pricePerKilo;
        this.discountStrategy = discountStrategy;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    public String getProductDescription(){
        return this.productDescription;
    }

    public BigDecimal getPrice(){
        return this.pricePerKilo;
    }

    public DiscountStrategy getDiscountStrategy() {
        return this.discountStrategy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeighedProduct that = (WeighedProduct) o;

        if (!pricePerKilo.equals(that.pricePerKilo)) return false;
        if (!productDescription.equals(that.productDescription)) return false;
        return discountStrategy.equals(that.discountStrategy);
    }

    @Override
    public int hashCode() {
        int result = pricePerKilo.hashCode();
        result = 31 * result + productDescription.hashCode();
        result = 31 * result + discountStrategy.hashCode();
        return result;
    }
}
