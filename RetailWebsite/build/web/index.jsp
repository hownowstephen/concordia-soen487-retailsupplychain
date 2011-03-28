<%-- 
    Document   : index
    Created on : Mar 26, 2011, 3:26:47 PM
    Author     : stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta name="author" content="Stephen Young & Team">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript" src="js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="js/jquery.soap.js"></script>
        <title>Order Products from XYZ Company</title>
        <script type="text/javascript" src="js/catalog.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>XYZ Company Catalog</h1>
            <p>Some blurb about what the company is all about, our motto and raisin debt</p>
            <div class="catalog-container">
                <h2>Catalog</h2>
                <div id="catalog">

                </div>
            </div>
            <div class="order-container">
                <div class="cart">
                    <h2>Your Shopping Cart</h2>
                    <table id="shopping-cart">
                        <tr><td>Name</td><td>Quantity</td></tr>
                        <tr class="cart-entry" id="empty"><td colspan=3>Cart is empty</td></tr>
                    </table>
                </div>
                <div class="order_form">
                    <h2>Order Now!</h2>

                </div>
            </div>
            <div class="footer">
                Sample company web purchasing workflow developed for SOEN487/4 at Concordia University
            </div>
        </div>


    </body>
</html>
