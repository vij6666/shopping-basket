package kata.supermarket;

import java.math.BigDecimal;

public class Product implements IProduct{

    private final BigDecimal pricePerUnit;
    private final String productDescription;
    private DiscountStrategy discountStrategy;

    public Product(final String productDescription, final BigDecimal pricePerUnit, final DiscountStrategy discountStrategy) {
        this.productDescription = productDescription;
        this.pricePerUnit = pricePerUnit;
        this.discountStrategy = discountStrategy;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public DiscountStrategy getDiscountStrategy(){
        return this.discountStrategy;
    }

    public BigDecimal getPrice(){
        return this.pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!pricePerUnit.equals(product.pricePerUnit)) return false;
        if (!productDescription.equals(product.productDescription)) return false;
        return discountStrategy.equals(product.discountStrategy);
    }

    @Override
    public int hashCode() {
        int result = pricePerUnit.hashCode();
        result = 31 * result + productDescription.hashCode();
        result = 31 * result + discountStrategy.hashCode();
        return result;
    }
}
