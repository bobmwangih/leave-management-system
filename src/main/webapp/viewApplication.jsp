<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>

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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
</head>
<body>
	<div class="container">
		<a href="index.jsp"><button type="button" class="btn btn-info">Back</button></a>
		<br> <br>
		<div class="card text-center border-success">
			<div class="card-header text-primary">	<h5>Leaves Applied</h5></div>
			 <div class="card-body text-success">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th scope="col">Employee Id</th>
						<th scope="col">leave Type</th>
						<th scope="col">Days Requested</th>
						<th scope="col">Intended Start Date</th>
						<th scope="col">Intended end Date</th>
						<th scope="col">Date of application</th>
						<th scope="col">Leave status</th>
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
								<c:when test="${status=='approved'}">
									<td><a
										href="download?leaveId=${leave.leaveId}&employeeId=${leave.employeeId}"
										data-toggle="tooltip"
										title="Download a pdf version of your approved leave!"><button
												class="btn btn-outline-success" type="button">Download</button></a></td>
								</c:when>

								<c:when test="${status=='declined'}">
									<td><a href="#" data-toggle="tooltip"
										title="The Leave application has been closed,no further action is Allowed!"><button
												class="btn btn-outline-danger" type="button">Closed</button></a></td>
								</c:when>
								<c:otherwise>
									<td><a
										href="edit?leaveId=${leave.leaveId}&employeeId=${leave.employeeId}"
										data-toggle="tooltip" title="Edit your application"><button
												class="btn btn-outline-primary" type="button">Edit</button></a>
									</td>
									<c:url var="deleteLink" value="/delete">
										<c:param name="leaveId" value="${leave.leaveId}"></c:param>
									</c:url>
									<td><a href="${deleteLink}" data-toggle="tooltip"
										title="Remove your application"><button
												class="btn btn-outline-danger " type="button"
												onclick="if(!(confirm('Your Leave application will be deleted,Continue?')))return false;">Delete</button></a>
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			</div>
		</div>
		</div>
</body>
</html>