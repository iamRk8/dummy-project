<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file = "template/header.jsp" %>
<div class="container">
  <h2>Products Available</h2>
  <table class="table">
    <thead>
      <tr>
        <th>S.N.</th>
        <th>Product image</th>
        <th>Product Name</th>
        <th>Product Quantity</th>
        <th>Product Price</th>
        <th>Product Description</th>
        <th>Category</th>
        <th>Action</th>
       
      </tr>
    </thead>
    <c:forEach items="${prolist }" var="p" varStatus"s">
    <tr>
    <td>$p{S.count}</td>
    <td><img alt="" src=""></td>
    <td>${p.pName}</td>
     <td>${p.pQuntity}</td>
      <td>${p.pPrice}</td>
       <td>${p.pDescriptopn}</td>
       <td>${p.category.cname}</td>
       <td>
       <button class="btn btn-succes">Update</button>
 			<button class="btn btn-danger">Delete</button>
 			</td>
	</tr>
	</c:forEach>
    <tbody>
   
    </tbody>
  </table>
</div>
<%@ include file = "template/footer.jsp" %>