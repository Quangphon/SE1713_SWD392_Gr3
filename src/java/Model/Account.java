/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hp
 */
public class Account {

    private int id;
    private String user_name;
    private String password;
    private String email;
    private String phone;
    private String image;
    private String is_active;
    private String full_name;
    private String address;
    private String role_name;

    public Account() {
    }

    public Account(int id, String user_name, String password, String email, String phone, String image, String is_active, String full_name, String address, String role_name) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.is_active = is_active;
        this.full_name = full_name;
        this.address = address;
        this.role_name = role_name;
    }

    public Account(int id, String user_name, String password, String email, String phone, String is_active, String full_name, String address, String role_name) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.is_active = is_active;
        this.full_name = full_name;
        this.address = address;
        this.role_name = role_name;
    }

    public Account(int id, String user_name, String email, String phone, String is_active, String full_name, String address, String role_name) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.phone = phone;
        this.is_active = is_active;
        this.full_name = full_name;
        this.address = address;
        this.role_name = role_name;
    }

    
    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

    public String isIs_active() {
        return is_active;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getAddress() {
        return address;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", user_name=" + user_name + ", password=" + password + ", email=" + email + ", phone=" + phone + ", image=" + image + ", is_active=" + is_active + ", full_name=" + full_name + ", address=" + address + ", role_name=" + role_name + '}';
    }
    
    

}
