<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <h2>Dynamic Tabs</h2>
  <p>To make the tabs toggleable, add the data-toggle="tab" attribute to each link. Then add a .tab-pane class with a unique ID for every tab and wrap them inside a div element with class .tab-content.</p>

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Product</a></li>
    <li><a data-toggle="tab" href="#menu1">Category</a></li>
    <li><a data-toggle="tab" href="#menu2">Supplier</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <div class="container">
  <h2>Vertical (basic) form</h2>
  <form:form action="saveProduct" modelAttribute="pro" enctype="multipart/form-data" method="post">
    <div class="form-group">
      <label for="email">Product Name:</label>
      <form:input path="pName" type="text" class="form-control" id="email" placeholder="product name"/>
    </div>
    <div class="form-group">
      <label for="email">Product Quantity:</label>
      <form:input path="pQuantity" type="text" class="form-control" id="email" placeholder="Quantity"/>
    </div>
    <div class="form-group">
      <label for="email">Product Price:</label>
      <form:input path="pPrice" type="text" class="form-control" id="email" placeholder="price"/>
    </div>
    <div class="form-group">
      <label for="email">Product Description:</label>
      <form:input path="pDescription" type="text" class="form-control" id="email" placeholder="Description"/>
    </div>
    
    <div class="form-group">
	  <label for="sel1">Select Category:</label>
	  <form:select path="category.cId" class="form-control" id="sel1" >
	  <form:option value="">---choose Category---</form:option>
	  	<form:options items="${catList}" itemValue="cId" itemLabel="cName" />
	  </form:select>
	</div>

<div class="form-group">
      <label for="email">Product picture:</label>
      <input path="pName" type="file" class="form-control" name="pic"/>
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
      
    </div>
    <div id="menu1" class="tab-pane fade">
      <div class="container">
  <form:form action="saveCategory" modelAttribute="cat" method="post">
    <div class="form-group">
      <label for="email">Category Name:</label>
      <form:input path="cName" type="text" class="form-control" id="email" placeholder="category name"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>

    </div>
    <div id="menu2" class="tab-pane fade">
      <div class="container">
  <h2>Vertical (basic) form</h2>
  <form:form action="saveSupplier" modelAttribute="sup" method="post">
    <div class="form-group">
      <label for="email">Supplier Name:</label>
      <form:input path="sName" type="text" class="form-control" id="email" placeholder="supplier name"/>
    </div>
    <div class="form-group">
	  <%-- <label>
	  <form:checkboxes items="${supList}" itemLabel="sName" path="supplier"></form:checkboxes>
	  </label> --%>
	  
	  <select name="pId" class="form-control" id="sel1">
	  <option value="">---choose products---</option>
	  <c:forEach var="p" items="${proList}">
	  	<option value="${p.pId}">${p.pName }</option>
	  	</c:forEach>
	  </select>
	</div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>

    </div>
  </div>
</div>
<%@ include file = "template/footer.jsp" %>

