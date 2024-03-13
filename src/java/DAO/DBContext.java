package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FPT University - PRJ301
 */
public class DBContext {

    protected Connection connection;

    public DBContext() {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {
            String IP = "localhost";
            String port = "1433";
            String db = "SWD392_gr3";
            String user = "sa";
            String pass = "123";           
            String url = "jdbc:sqlserver://"+IP+"\\SQLEXPRESS:"+port+";databaseName="+db+"";
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";          
            Class.forName(driver);           
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi vai lol");
        }
    }

    public static void main(String[] args) {
        System.out.println("thanh cong");
        DBContext db = new DBContext();
        
    }
}
