package ca.sheridancollege.siddmuns.assignment1.service;

import ca.sheridancollege.siddmuns.assignment1.model.Inventory;
import ca.sheridancollege.siddmuns.assignment1.model.Product;
import ca.sheridancollege.siddmuns.assignment1.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShopService {
    public void addProductToShoppingCart(int id);

    public void insertProductToInventory(int id, String name, float price);


    public List<Product> getAllProducts();

    Object getShoppingCart();
}
