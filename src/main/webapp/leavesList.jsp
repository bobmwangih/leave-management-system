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
		<div class="row justify-content-end">
			<a href="getApprover"><button class="btn btn-outline-success"
					type="button">See Reviews</button></a>
		</div>
		<a href="index.jsp"><button type="button" class="btn btn-info">Back</button></a>
		<br> <br>
		<div class="card text-center border-success">
			<div class="card-header text-primary"><h5>List of leaves</h5></div>
			  <div class="card-body text-success">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th scope="col">Employee Id</th>
						<th scope="col">leave Type</th>
						<th scope="col">Days Requested</th>
						<th scope="col">Intended leave start date</th>
						<th scope="col">Intended leave end date</th>
						<th scope="col">Date of application</th>
						<th scope="col">Leave status</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${leaves}" var="leave">
						<tr>
							<td><c:out value="${leave.employeeId}" /></td>
							<td><c:out value="${leave.leaveType}" /></td>
							<td><c:out value="${leave.daysRequested}" /></td>
							<td><c:out value="${leave.startDate}" /></td>
							<td><c:out value="${leave.endDate}" /></td>
							<td><c:out value="${leave.dateOfApplication}" /></td>
							<td><c:out value="${leave.status}" /></td>
							<c:set var="status" value="${leave.status}" />
							<c:choose>
								<c:when test="${status=='approved' || status =='declined'}">
									<td><a href="#" title="" data-toggle="popover"
										data-placement="top" data-trigger="focus"
										data-content="The application has been closed,no further action is required!""><button
												class="btn btn-outline-danger" type="button">Closed</button></a></td>
								</c:when>

								<c:otherwise>
									<td><a
										href="view?leaveId=${leave.leaveId}&employeeId=${leave.employeeId}"
										data-toggle="tooltip" title="To approve/reject application"><button
												class="btn btn-outline-primary btn-sm" type="button">View
												Application</button></a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>