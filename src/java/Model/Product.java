/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Product {
    private int id;
    private String product_name;
    private double price;
    private int quantity;
    private String image;
    private String description;
    private int cate_id;

    public Product() {
    }

    public Product(int id, String product_name, double price, int quantity, String image, String description, int cate_id) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.cate_id = cate_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", product_name=" + product_name + ", price=" + price + ", quantity=" + quantity + ", image=" + image + ", description=" + description + ", cate_id=" + cate_id + '}';
    }
    
    // Your existing fields and methods
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id; // Assuming 'id' uniquely identifies a product
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
