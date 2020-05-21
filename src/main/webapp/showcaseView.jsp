<!-- <%@ page import="com.spe.CentralSellerPortal.Controllers.SpringSessionController" %>
<%@ page import="com.spe.CentralSellerPortal.Entities.Seller" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.spe.CentralSellerPortal.Entities.Product" %>
<%@ page import="org.springframework.http.ResponseEntity" %>
<%@ page import="com.spe.CentralSellerPortal.Controllers.SellerController" %>
<%@ page import="com.spe.CentralSellerPortal.Controllers.ProductController" %>
<%@ page import="org.springframework.web.bind.annotation.RequestMapping" %>
<%--<%@ page import="org.springframework.web.bind.annotation.RequestBody" %>--%> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Sellers</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
    <style>
        img {
            border-radius: 50%;
        }
    </style>
</head>
<body>
<div class="jumbotron" id="ecomm-profile" style="font-size: large; font-family: Ubuntu " >
    <div class="container">
        <div id="seller-profile">
            <td><h2><b>Product Listed on ,    ${ecommName}</b></h2>         </td>
        </div>
    </div>
</div>
<div id="product-table" class="container" >
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th style="font-size:20px">Image</th>
                    <th style="font-size:20px">Name</th>
                    <th style="font-size:20px">Description</th>
                    <th style="font-size:20px">Price</th>
                    <th style="font-size:20px">Discount</th>
                    <th style="font-size:20px">Shop Name</th>
                    </thead>
                    <tbody>
                    <c:forEach var="e" items="${showcaseList}">

                        <tr>
                            <td><img src="${e.image}" alt="Image Unavailable" width="150" height="150"></td>
                            <td><br><br>${e.productName}</td>
                            <td><br><br>${e.productDescription}</td>
                            <td><br><br>${e.price}</td>
                            <td><br><br>${e.discount}</td>
                            <td><br><br>${e.seller.shopName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>

<br>


</body>
</html>