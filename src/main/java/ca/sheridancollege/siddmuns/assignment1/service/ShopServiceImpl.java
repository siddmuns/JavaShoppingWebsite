package ca.sheridancollege.siddmuns.assignment1.service;

import ca.sheridancollege.siddmuns.assignment1.model.Inventory;
import ca.sheridancollege.siddmuns.assignment1.model.Product;
import ca.sheridancollege.siddmuns.assignment1.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final Inventory inventory = new Inventory();
    private final ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public void addProductToShoppingCart(int id) {
        Product newItem = inventory.getProductById(id);
        shoppingCart.insertItemToCart(newItem);
    }

    @Override
    public void insertProductToInventory(int id, String name, float price) {
        Product product = new Product(id,name,price);
        inventory.insertProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return inventory.getProducts();
    }

    @Override
    public Object getShoppingCart() {
        return shoppingCart.getCartItems();
    }
}
