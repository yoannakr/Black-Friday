<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8.1.2020 г.
  Time: 23:43
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
                <li class="nav-item col-md-2">
                    <a class="nav-link text-white active font-weight-bold"
                       href="/products/create">Add Product</a>
                </li>
                <li class="nav-item col-md-2">
                    <a class="nav-link text-white active font-weight-bold"
                       href="/products/available">Available Product</a>
                </li>
                <li class="nav-item col-md-2">
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
    <form class="mx-auto w-15" method="post" action="/products/create">
        <div class="row">
            <div class="col col-md-3"></div>
            <div class="col col-md-3">
                <div class="form-group">
                    <div class="label-holder d-flex justify-content-center">
                        <label class="text-center text-white font-weight-bold" for="name">Name
                            <input type="text" class="form-control" name="name" id="name" placeholder="Name">
                        </label>
                    </div>
                </div>
            </div>
            <div class="col col-md-3">
                <div class="form-group">
                    <div class="label-holder d-flex justify-content-center">
                        <label class="text-center text-white font-weight-bold" for="quantity">Quantity
                            <input type="number" min="1" class="form-control" name="quantity" id="quantity"
                                   placeholder="Quantity">
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col col-md-3"></div>
            <div class="col col-md-3">
                <div class="form-group">
                    <div class="label-holder d-flex justify-content-center">
                        <label class="text-center text-white font-weight-bold" for="price">Price
                            <input type="number" min="0.01" step="0.01" class="form-control" placeholder="Price" name="price"
                                   id="price">
                        </label>
                    </div>
                </div>
            </div>
            <div class="col col-md-3">
                <div class="form-group">
                    <div class="label-holder d-flex justify-content-center">
                        <label class="text-center text-white font-weight-bold" for="minPrice">Minimal Price
                            <input type="number" min="0.01" step="0.01" class="form-control" placeholder="Minimal Price"
                                   name="minPrice"
                                   id="minPrice">
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col col-md-4"></div>
            <div class="col col-md-4">
                <div class="button-holder d-flex justify-content-center">
                    <input type="submit" class="btn btn-secondary" value="Add Product"/>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>