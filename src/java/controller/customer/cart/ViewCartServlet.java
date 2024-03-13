/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.customer.cart;

import dao.*;
import DTO.ShoppingCartDTO;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ViewCartServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewCartServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewCartServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession(true);
        // Retrieve the shopping cart from the session
        ShoppingCartDTO cart = (ShoppingCartDTO) session.getAttribute("cart");
        
        if(cart == null){
            //Seed data to test cart
//            cart = new ShoppingCartDTO();
//            cart.addItem(new Product(1,"tivi", 1.5, 6, "https://cdn.tgdd.vn/Products/Images/1942/75873/tivi-panasonic-th-40d400v-org-1.jpg", "description", 1), 10);
//            Map<Product, Integer> tableProduct = cart.getItems();
//            request.setAttribute("tableProduct", tableProduct);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }else{
            Map<Product, Integer> tableProduct = cart.getItems();
            request.setAttribute("tableProduct", tableProduct);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        //increase, decrease, remove Product from cart...
        String type = request.getParameter("type");
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        ProductDAO productDAO = new ProductDAO();
        
        HttpSession session = request.getSession(true);
        // Retrieve the shopping cart from the session
        ShoppingCartDTO cart = (ShoppingCartDTO) session.getAttribute("cart");
        
        Product product = productDAO.getProductById(productId);
        
        switch (type) {
            case "removeItem":
                cart.removeItem(product);
                break;
            case "increase":
                cart.increaseQuantity(product);
                break;
            case "decrease":
                cart.decreaseQuantity(product);
                break;
            default:
                break;
        }
        session.setAttribute("cart", cart);
        
        // Forward the request to doGet() to load cart
        doGet(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
