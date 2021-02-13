<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Leaves</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container">
		<a href="index.jsp"><button type="button" class="btn btn-info">Back</button></a>
		<br> <br>

		<div class="card text-center border-success">
			<div class="card-header text-primary"><h5>Closed Leaves</h5></div>
			  <div class="card-body text-success">
			<table class="table table-striped table-bordered">

				<thead>
					<tr>
						<th scope="col">Review Id</th>
						<th scope="col">Review Type</th>
						<th scope="col">Remarks</th>
						<th scope="col">Date of approval</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${approver.reviews}" var="review">

						<tr>
							<td><c:out value="${review.reviewId}" /></td>
							<td><c:out value="${review.reviewType}" /></td>
							<td><c:out value="${review.remarks}" /></td>
							<td><c:out value="${review.dateOfApproval}" /></td>

						</tr>

					</c:forEach>

				</tbody>
			</table>
			</div>
			<div class="card-footer"><h6>Approver: ${approver.firstName} ${approver.lastName}</h6></div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>