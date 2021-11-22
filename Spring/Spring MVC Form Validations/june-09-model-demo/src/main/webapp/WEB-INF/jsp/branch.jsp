<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron">
	<h1 class="text-center">Branch Form</h1>
</div>
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<form:form method="POST" action="branch" modelAttribute="branch">
			Id:<form:input path="bid" class="form-control" />
			<form:errors cssStyle="color:red" path="bid" /><br/>
			Name:<form:input path="bname" class="form-control" />
			<form:errors cssStyle="color:red" path="bname" /><br/>
			City:<form:input path="bcity" class="form-control" /><br/>
			<input type=submit name="add" class="btn btn-success" value="Add" />
			<input type=submit name="modify" class="btn btn-warning" value="Modify" />
			<input type=submit name="delete" class="btn btn-danger" value="Delete" />
			
		</form:form>
	</div>
	<div class="col-md-4"></div>
</div><br/><br/>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>City</th>
			<th></th>
		</thead>
		<c:forEach var="b" items="${branches }">
			<tr>
				<td>${b.bid }</td>
				<td>${b.bname }</td>
				<td>${b.bcity }</td>
				<td><a href="/select?bid=${b.bid }">Select</a></td>
			</tr>		
		</c:forEach>
	</table>		
	</div>
	<div class="col-md-2"></div>
</div>

</body>
</html>