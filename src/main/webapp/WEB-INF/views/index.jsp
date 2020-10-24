<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div class="container mt-3">
<div class="row">
<div class="col-md-12">
<h1 class="text-center mb-3">Welcome to Product App</h1>
<table class="table">
<thead class="thead-dark">
<tr>
<th Scope="col">ID</th>
<th Scope="col">Product Name</th>
<th Scope="col">Description</th>
<th Scope="col">Price</th>
<th Scope="col">Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${products}" var="p">
<tr>
<th scope="row">PanKart${p.id}</th>
<td>${p.name }</td>
<td>${p.description}</td>
<td class="font-weight-bold">&#x20B9;${p.price}</td>
<td><a href="delete/${p.id}"><i class="fas fa-trash text-danger" style="font-size: 30px;"></i></a>
   <a href="update/${p.id}"><i class="fas fa-pen-nib text-primary" style="font-size: 30px;"></i></a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<div class="container text-center">
<a href="add-product" class="btn btn-outline-success">Add Product</a>
</div>
</div>
</div>
</div>
</body>
</html>