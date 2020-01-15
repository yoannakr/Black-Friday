<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.view.BlackFridayViewModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.1.2020 г.
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Joanna's shop</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-background">
        <a class="nav-link text-white active h5" href="/home">Home</a>
        <div class="collapse navbar-collapse d-flex justify-content-end">
            <ul class="navbar-nav row">
                <li class="nav-item col-md-3">
                    <a class="nav-link text-white active font-weight-bold"
                       href="/products/create">Add Product</a>
                </li>
                <li class="nav-item col-md-3">
                    <a class="nav-link text-white active font-weight-bold"
                       href="/products/blackFriday">Black Friday</a>
                </li>
                <li class="nav-item col-md-3">
                    <a class="nav-link text-white active font-weight-bold" href="/products/all">All Products</a>
                </li>
                <li class="nav-item col-md-3">
                    <form action="/LogoutServlet" method="post">
                        <input type="submit" value="Logout">
                    </form>
                </li>
            </ul>
        </div>
    </nav>
    <h2 class="text-center text-white mt-5">Black Friday</h2>
    <hr style="width: 50%"/>
    <div class='row mb-4 d-flex justify-content-around'>
        <% for (BlackFridayViewModel product : ((List<BlackFridayViewModel>) request.getAttribute("blackFridayViewModel"))) {%>
        <% if (product.getQuantity() > 0) { %>
        <div class="col-md-4 d-flex flex-column bg-text mb-3">
            <h2>Owner: <%= product.getUserUsername() %>
            </h2>
            <h2>Name: <%= product.getName() %>
            </h2>
            <h4>Quantity: <%= product.getQuantity() %>
            </h4>
            <h4>Discount: <%= product.getDiscount() %>
            </h4>
            <h4>New Price: <%= product.getDiscountedPrice() %>
            </h4>
            <div class="button-holder d-flex justify-content-center">
                <a class="btn btn-secondary"
                   href="/products/buy?id=<c:out value='<%= product.getId() %>' />&name=<c:out value='<%= product.getName() %>' />&price=<c:out value='<%= product.getDiscountedPrice() %>' />">
                    Buy</a>
            </div>
        </div>
        <% } %>
        <% } %>
    </div>
</div>
</body>
</html>
