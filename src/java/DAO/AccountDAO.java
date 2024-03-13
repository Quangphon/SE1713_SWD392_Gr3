/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class AccountDAO extends DBContext {

    public ArrayList<Account> getListAccount() {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "select * from Account a join [Role] r \n"
                + "  on a.role_id = r.id";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
//                int id = rs.getInt(1);
//                String userName = rs.getString(2);
//                String email = rs.getString(4);
//                String phone = rs.getString(5);
//                String imageP = rs.getString(6);
//                String is_Active = rs.getBoolean(7);
//                String fullName = rs.getString(8);
//                String address = rs.getString(9);
//                String role_name = rs.getString(12);
                Account a;
                a = new Account(rs.getInt(1), rs.getString(2),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12));
                list.add(a);
            }   
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println("getListAccount():  " + e.getMessage());
        }
        return null;
    }

      public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        ArrayList<Account> a1 = a.getListAccount();
        System.out.println(a1);
    }
    
    
}
