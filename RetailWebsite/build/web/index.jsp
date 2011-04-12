<%-- 
    Document   : index
    Created on : Mar 26, 2011, 3:26:47 PM
    Author     : stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Order Products from XYZ Company</title>
        <!-- Meta information -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta name="author" content="Stephen Young, Jose Salvidar, Fabrice Bloncourt">
        <!-- Css -->
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" type="text/css" href="fancybox/jquery.fancybox-1.3.4.css">
        <!-- JS Libraries -->
        <script type="text/javascript" src="js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="js/jquery.xmltojson.js"></script>
        <script type="text/javascript" src="js/jquery.soap.js"></script>
        <script type="text/javascript" src="fancybox/jquery.fancybox-1.3.4.pack.js"></script>
        <!-- JS -->
        <script type="text/javascript" src="js/catalog.js"></script>
        <script type="text/javascript" src="js/order.js"></script>
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
                        <tr class="cart-entry" id="empty"><td colspan="3">Cart is empty</td></tr>

                    </table>
                </div>
                <div class="order_form">
                    <h2>Order Now!</h2>

                    <form id="orderForm" action="sendOrder" method="POST">
                        <table>
                            <tbody><tr>
                                <td>
                                    <label for="name">Name</label>
                                </td>
                                <td>
                                    <input type="text" name="name">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="email">Email Address</label>
                                </td>
                                <td>
                                    <input type="text" name="email">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="email2">Email (again)</label>
                                </td>
                                <td>
                                    <input type="text" name="email2">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="name">Country</label>
                                </td>
                                <td>
                                    <input type="text" name="country">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="name">State/Province</label>
                                </td>
                                <td>
                                    <input type="text" name="state">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="addr1">Address1</label>
                                </td>
                                <td>
                                    <input type="text"  name="addr1">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="addr2">Address2</label>
                                </td>
                                <td>
                                    <input type="text"  name="addr2">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <img src="img/ajax-loader.gif" id="submit_in_progress" style="display:none;" />
                                    <input id="submitbtn" type="submit" value="Submit Order!" />
                            </td></tr>
                        </tbody></table>
                    </form>

                </div>
            </div>
            <div class="footer">
                Sample company web purchasing workflow developed for SOEN487/4 at Concordia University
            </div>
        </div>
    </body>
</html>