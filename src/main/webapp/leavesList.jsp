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
		
		<div class="row justify-content-left">
			<a href="index.jsp"><button type="button" class="btn btn-info">Back</button></a>
		</div>
		<br> <br>
		<div class="card text-center border-success">
			<div class="card-header text-primary">
				<h5>Leaves Pending approval</h5>
			</div>
			<div class="card-body text-success">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th scope="col">Employee Id</th>
							<th scope="col">Name</th>
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
						<c:set var="employee" value="${leave.employee}"></c:set>
							<tr>
								<td><c:out value="${leave.employeeId}" /></td>
								<td><c:out value="${employee.firstName} ${employee.lastName}" /></td>
								<td><c:out value="${leave.leaveType}" /></td>
								<td><c:out value="${leave.daysRequested}" /></td>
								<td><c:out value="${leave.startDate}" /></td>
								<td><c:out value="${leave.endDate}" /></td>
								<td><c:out value="${leave.dateOfApplication}" /></td>
								<td><c:out value="${leave.status}" /></td>
								<c:set var="status" value="${leave.status}" />
								<td><a
									href="view?leaveId=${leave.leaveId}&employeeId=${leave.employeeId}"
									data-toggle="tooltip" title="To approve/reject application"><button
											class="btn btn-outline-primary btn-sm" type="button">View
											Application</button></a></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

		<br> <br>

		<div class="card text-center border-success">
			<div class="card-header text-primary">
				<h5>Approved /Rejected Leaves</h5>
			</div>
			<div class="card-body text-success">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th scope="col">Employee Id</th>
							<th scope="col">Name</th>
							<th scope="col">leave Type</th>
							<th scope="col">Days Requested</th>
							<th scope="col">Intended leave start date</th>
							<th scope="col">Intended leave end date</th>
							<th scope="col">Date of application</th>
							<th scope="col">Date of Approval</th>
							<th scope="col">Approver's Remarks</th>
							<th scope="col">Leave status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${leavesWithReviews}" var="leaveWithRevs">
						<c:set var="employee" value="${leaveWithRevs.employee}"></c:set>
							<tr>
								<td><c:out value="${leaveWithRevs.employeeId}" /></td>
								<td><c:out value="${employee.firstName} ${employee.lastName}" /></td>
								<td><c:out value="${leaveWithRevs.leaveType}" /></td>
								<td><c:out value="${leaveWithRevs.daysRequested}" /></td>
								<td><c:out value="${leaveWithRevs.startDate}" /></td>
								<td><c:out value="${leaveWithRevs.endDate}" /></td>
								<td><c:out value="${leaveWithRevs.dateOfApplication}" /></td>
								<td><c:out value="${leaveWithRevs.dateOfApproval}" /></td>
								<c:set var="leaveRemark" value="${leaveWithRevs.review}" />
								<td><c:out value="${leaveRemark.remarks}" /></td>
								<c:set var="leaveStatus" value="${leaveWithRevs.status}" />
								<c:choose>
									<c:when test="${leaveStatus=='approved'}">
										<td><a href="#" title="" data-toggle="popover"
											data-placement="top" data-trigger="focus"
											data-content="The application has been closed,no further action is required!""><button
													class="btn btn-outline-success" type="button">Approved</button></a></td>
									</c:when>

									<c:otherwise>
										<td><a href="#" title="" data-toggle="popover"
											data-placement="top" data-trigger="focus"
											data-content="The application has been closed,no further action is required!""><button
													class="btn btn-outline-danger" type="button">Rejected</button></a></td>
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