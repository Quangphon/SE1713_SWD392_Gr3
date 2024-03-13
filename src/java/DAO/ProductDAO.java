/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Product;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext{
    public Product getProductById(int id) {
        String sql = "select * from Product where id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int idP = rs.getInt(1);
                String nameP = rs.getString(2);
                double priceP = rs.getDouble(3);
                int quantityP = rs.getInt(4);
                String imageP = rs.getString(5);
                String descriptionP = rs.getString(6);
                int cate_idP = rs.getInt(7);
                
                return new Product(id, nameP, priceP, quantityP, imageP, descriptionP, cate_idP);
            }
        } catch (Exception e) {
            System.out.println("getProductById: "+e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        Product pr = p.getProductById(1);
        System.out.println(pr);
    }
}
