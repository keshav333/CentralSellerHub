
<%@ page import="com.acms.CentralSellerPortal.Entities.Seller" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.acms.CentralSellerPortal.Entities.Product" %>
<%@ page import="org.springframework.http.ResponseEntity" %>
<%@ page import="com.acms.CentralSellerPortal.Controllers.SellerController" %>
<%@ page import="com.acms.CentralSellerPortal.Controllers.ProductController" %>
<%@ page import="org.springframework.web.bind.annotation.RequestMapping" %>
<%--<%@ page import="org.springframework.web.bind.annotation.RequestBody" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Seller Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/main.css">

    <%--    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
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
<% long id = Long.parseLong(request.getParameter("id")); %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="font-size: medium; background-color: #2A2A2A ; font-family: Ubuntu">
    <div class="container">
        <div class="navbar-header">
            <form class ="form-view" id="view-form-head"   method="get">
                <form :hidden path="id"/>
                <div class="form-row">
                    <div class="form-group">
                        <a  type="submit"  href="/EcommDashboard.jsp?e_id=<%=id%>" style="color: whitesmoke" class="btn"> Central Seller Portal</a>
                    </div> <!-- form-group// -->
                    <!-- form-group end.// -->
                </div>
            </form>
        </div>
  
        <div class="navbar-header">
            <form class ="form-view" id="view-form-view-sellers" action="/ecommsell/ecommproducts" method="get">
                <form :hidden path="id"/>
                <div class="form-row">
                    <div class="form-group">
                        <button id = "view-sellers" type="submit"   style="color: whitesmoke; background-color: #2A2A2A" class="btn"> View All Products</button>
                    </div> <!-- form-group// -->
                    <!-- form-group end.// -->
                </div>
            </form>
        </div>

        <div class="navbar-header">
            <form class ="form-view" id="view-form-viewproduct" action = "/" method="get">
                <form :hidden path="id"/>
                <div class="form-row">
                    <div class="form-group">
                        <button  id = "view-profile-viewproduct" type="submit"  style="color: whitesmoke; background-color: #2A2A2A" class="btn"> View Added Products</button>
                    </div> <!-- form-group// -->
                    <!-- form-group end.// -->
                </div>
            </form>
        </div>
        <div class="navbar-header">
            <form class ="form-view" id="view-form" action="/destroy" method="post">
                <form :hidden path="id"/>
                <div class="form-row">
                    <div class="form-group">
                        <button class="btn" type="submit" style="color: whitesmoke; background-color: #2A2A2A" role="button">Logout</button>
                    </div> <!-- form-group// -->
                    <!-- form-group end.// -->
                </div>
            </form>
        </div>
    </div>
</nav>
<br>


<div id="product-table" class="container" >
    <div class="row">
        <div class="col-md-12">
            <h4> ${sellerName}, Here are All Products</h4>
            <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price(Rs.)</th>
                    <th>Add</th>
                    <%--                <th>Add</th>--%>
                    </thead>
                    <tbody>
                    <c:forEach var="e" items="${productList}">
                        <tr>
                            <td><img src="${e.image}" alt="Image Unavailable" width="100" height="100"></td>
                            <td>${e.productName}</td>
                            <td>${e.productDescription}</td>
                            <td>${e.price}</td>
                            <td><a data-placement="top" data-toggle="tooltip" href="/ecom/add/${e.productId}"  action="" title="Add"><button class="submit" name="add"><i class="fas fa-plus"></i></button></a></td>
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