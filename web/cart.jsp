<%-- 
    Document   : cart
    Created on : 13/03/2024, 1:21:02 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>
        .shoping__cart__item{
            img{
                width: 80px;
                height: 80px;
            }
        }
    </style>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
        <header class="header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo" style='padding: 0px'>
                            <a href="./index.html"><img style="height: 80px" src="img/logo.jpg" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="./index.html">Home</a></li>
                                <li><a href="./shop-grid.html">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="header__menu__dropdown">
                                        <li><a href="./shop-details.html">Shop Details</a></li>
                                        <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                                        <li><a href="./checkout.html">Check Out</a></li>
                                        <li><a href="./blog-details.html">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
                                <!--<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>-->
                                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                            </ul>
                            <div class="header__top__right__auth">
                                <a href="./login.html"><i class="fa fa-user"></i> Login</a>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->

        <!-- Breadcrumb Section Begin (Quang cao) -->
<!--       <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.png" style="margin-bottom: 50px">
        </section>    
         comment 

         Hero Section Begin 
        <section class="hero hero-normal">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">

                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="#">
                                    <div class="hero__search__categories">
                                        All Categories
                                        <span class="arrow_carrot-down"></span>
                                    </div>
                                    <input type="text" placeholder="What do yo u need?">
                                    <button type="submit" class="site-btn">SEARCH</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>-->
        <!-- Hero Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <c:if test="${tableProduct == null}">
                            <h3>Please Add Item To Cart</h1></br>
                            <div class="shoping__cart__btns">
                                <a href="home.jsp" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                            </div>
                        </c:if>
                            
                        <c:if test="${tableProduct != null}">
                            <table>
                                <thead>
                                    <tr>
                                        <th class="shoping__product">Products</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                        <c:set var="total" value="0" />
                                        <c:forEach var="entry" items="${tableProduct}">
                                            <c:set var="product" value="${entry.key}" />
                                            <c:set var="quantity" value="${entry.value}" />
                                            <tr>
                                                <td class="shoping__cart__item">
                                                    <img src="${product.getImage()}" alt="abc">
                                                    <h5>${product.getProduct_name()}</h5>
                                                </td>
                                                <td class="shoping__cart__price">
                                                   $ ${product.getPrice()}
                                                </td>
                                                <td class="shoping__cart__quantity">
                                                    <div class="quantity">
                                                        <div class="pro-qty">
                                                            <form id="formDecreaseQuantity" action="ViewCartServlet" method="post">
                                                                <input type="hidden" name="type" value="decrease" />
                                                                <input type="hidden" name="productId" value="${product.getId()}" />
                                                             </form>
                                                            <span onclick="decreaseQuantity()" class="dec qtybtn">-</span>
                                                            <input type="text" value="${quantity}">
                                                            <span onclick="increaseQuantity()" class="inc qtybtn">+</span>
                                                            <form id="formIncreaseQuantity" action="ViewCartServlet" method="post">
                                                                <input type="hidden" name="type" value="increase" />
                                                                <input type="hidden" name="productId" value="${product.getId()}" />
                                                             </form>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="shoping__cart__total">
                                                    $ ${product.getPrice() * quantity}
                                                    <c:set var="total" value="${total + product.getPrice() * quantity}" />
                                                </td>
                                                <form id="formRemoveItem" action="ViewCartServlet" method="post">
                                                    <input type="hidden" name="type" value="removeItem" />
                                                    <input type="hidden" name="productId" value="${product.getId()}" />
                                                    <td class="shoping__cart__item__close">
                                                        <span onclick="removeItem()" class="icon_close"></span>
                                                    </td>
                                                </form>
                                                
                                            </tr>
                                        </c:forEach>


                                </tbody>
                            </table>
                            </br>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="shoping__cart__btns">
                                        <a href="#" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                                        <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                                            Upadate Cart</a>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="shoping__continue">
                                        <div class="shoping__discount">
                                            <h5>Discount Codes</h5>
                                            <form action="#">
                                                <input type="text" placeholder="Enter your coupon code">
                                                <button type="submit" class="site-btn">APPLY COUPON</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="shoping__checkout">
                                        <h5>Cart Total</h5>
                                        <ul>
                                            <li>Total <span>$ ${total}</span></li>
                                        </ul>
                                        <a href="./checkout.html" class="primary-btn">PROCEED TO CHECKOUT</a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        
                    </div>
                </div>
            </div>
            
        </div>
    </section>
    <!-- Shoping Cart Section End -->

   <!-- Footer Section Begin -->
        <footer class="footer spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__about__logo">
                                <a href="./index.html"><img style="height: 80px" src="img/logo.jpg" alt=""></a>
                            </div>
                            <ul>
                                <li>Address: Hoa Lac, Thach That, Ha noi</li>
                                <li>Phone: 0976055102</li>
                                <li>Email: quang@gmail.com</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                        <div class="footer__widget">
                            <h6>Useful Links</h6>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">About Our Shop</a></li>
                                <li><a href="#">Secure Shopping</a></li>
                                <li><a href="#">Delivery infomation</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Our Sitemap</a></li>
                            </ul>
                            <ul>
                                <li><a href="#">Who We Are</a></li>
                                <li><a href="#">Our Services</a></li>
                                <li><a href="#">Projects</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Innovation</a></li>
                                <li><a href="#">Testimonials</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="footer__widget">
                            <h6>Join Our Newsletter Now</h6>
                            <p>Get E-mail updates about our latest shop and special offers.</p>
                            <form action="#">
                                <input type="text" placeholder="Enter your mail">
                                <button type="submit" class="site-btn">Subscribe</button>
                            </form>
                            <div class="footer__widget__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
    
    <script>
        function removeItem() {
            document.getElementById("formRemoveItem").submit();
        }
        
        function increaseQuantity() {
            document.getElementById("formIncreaseQuantity").submit();
        }
        
        function decreaseQuantity() {
            document.getElementById("formDecreaseQuantity").submit();
        }
    </script>

</body>

</html>
