package ca.sheridancollege.siddmuns.assignment1.service;

import ca.sheridancollege.siddmuns.assignment1.model.Inventory;
import ca.sheridancollege.siddmuns.assignment1.model.Product;
import ca.sheridancollege.siddmuns.assignment1.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


public interface ShopService {
    int getRandomId();

    void addProductToShoppingCart(int id);

    void insertProductToInventory(Product product);

    int getCartCapacity();

    float getSubTotal();

    float getSalesTax();

    float getTotal();

    List<Product> getAllProducts();

    List<Product> getShoppingCart();
}
