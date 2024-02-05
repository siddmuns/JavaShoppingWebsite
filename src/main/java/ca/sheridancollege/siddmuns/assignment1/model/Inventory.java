package ca.sheridancollege.siddmuns.assignment1.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Inventory {
    private final List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void insertProduct(Product product) {
        products.add(product);
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
