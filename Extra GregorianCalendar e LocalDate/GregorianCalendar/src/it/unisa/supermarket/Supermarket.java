package it.unisa.supermarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Supermarket {

    private final List<Product> products;

    public Supermarket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        this.products.add(p);
        this.products.sort(new ProductComparatorByCode());
    }

    public List<Product> getProducts() {
        return products;
    }

    String getProductType(int i) {
        Product p = products.get(i);
        if (p instanceof Grocery)
            return "Grocery";

        return "Electronic";
    }

    Product getMinPrice() {
        return Collections.min(this.products, new ProductComparatorByPrice());
    }

    Product getMaxPrice() {
        return Collections.max(this.products, new ProductComparatorByPrice());
    }

    List<Product> find(String brand) {
        List<Product> lukaku = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getBrand().equals(brand))
                lukaku.add(p);
        }
        return lukaku;
    }
}
