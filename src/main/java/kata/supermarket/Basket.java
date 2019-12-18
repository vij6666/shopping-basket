package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Basket {
    private final Map<IProduct, BigDecimal> itemsToAmountMap;

    public Basket() {
        this.itemsToAmountMap = new HashMap<>();
    }

    public void add(final Item item) {
        if (itemsToAmountMap.containsKey(item.getProduct())){
            if(item instanceof ItemByUnit) {
                itemsToAmountMap.put(item.getProduct(), itemsToAmountMap.get(item.getProduct()).add(new BigDecimal(1)));
            }
            if(item instanceof ItemByWeight){
                itemsToAmountMap.put(item.getProduct(), itemsToAmountMap.get(item.getProduct()).add(((ItemByWeight) item).getWeightInKilos()));
            }
        } else {
            if(item instanceof ItemByUnit) {
                itemsToAmountMap.put(item.getProduct(), new BigDecimal(1));
            }
            if(item instanceof ItemByWeight){
                itemsToAmountMap.put(item.getProduct(), ((ItemByWeight) item).getWeightInKilos());
            }
        }
    }


    Map<IProduct, BigDecimal> items() {
        return Collections.unmodifiableMap(itemsToAmountMap);
    }

    public BigDecimal total() {
        return new Checkout(this).calculateSubtotal();
    }

}
