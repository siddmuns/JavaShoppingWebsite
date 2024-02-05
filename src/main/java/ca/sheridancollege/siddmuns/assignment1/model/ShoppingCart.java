package ca.sheridancollege.siddmuns.assignment1.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShoppingCart {
    private final List<Product> cartItems;

    private int capacity;

    private float priceTotal;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
        this.capacity = 0;
        this.priceTotal= 0;
    }

    public void insertItemToCart (Product product) {
        cartItems.add(product);
        capacity++;
        priceTotal += product.getPrice();
    }
}
