/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Model.Product;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ShoppingCartDTO {
    private Map<Product, Integer> items;
    
    public ShoppingCartDTO() {
        items = new HashMap<>();
    }
    
    public void addItem(Product product, int quantity) {
        // Check if the product already exists in the cart
        if (items.containsKey(product)) {
            // If it exists, update the quantity
            int currentQuantity = items.get(product);
            items.put(product, currentQuantity + quantity);
        } else {
            // If it doesn't exist, add it with the given quantity
            items.put(product, quantity);
        }
    }
    
    public void removeItem(Product product){
        if(items.containsKey(product)){
            items.remove(product);
        }
    }
    
    public void increaseQuantity(Product product) {
        if(items.containsKey(product)){
            items.put(product, items.get(product) + 1);
        }
    }
    
    public void decreaseQuantity(Product product) {
        if(items.containsKey(product)){
            if(items.get(product) == 1){
                removeItem(product);
            }else{
                items.put(product, items.get(product) - 1);
            }
        }
    }
    
    public int getQuantityByProduct(Product product) {
        return items.get(product);
    }
    
    public Map<Product, Integer> getItems() {
        return items;
    }
}
