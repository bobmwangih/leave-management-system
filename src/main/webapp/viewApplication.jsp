<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Application</title>

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
		<div class="card">
			<div class="card-header text-primary text-center">
				<h5>Leave Management System</h5>
			</div>
			<div class="card-body">
				<div class="text-left">
					<a href="index.jsp"><button type="button" class="btn btn-info">Back</button></a>
				</div>
				<br> <br>
				<div class="card text-center border-danger" style="max-width: auto;">
					<div class="card-header text-primary">
						<h5>Leave Pending Approval</h5>
					</div>
					<div class="card-body text-success">
						<table class="table table-striped table-bordered table-hover"
							style="max-width: auto;">
							<thead>
								<tr>
									<th scope="col">Employee Id</th>
									<th scope="col">leave Type</th>
									<th scope="col">Days Requested</th>
									<th scope="col">Intended Start Date</th>
									<th scope="col">Intended end Date</th>
									<th scope="col">Date of application</th>
									<th scope="col">Date of approval</th>
									<th scope="col">Leave status</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="theLeavesPendingApproval" value="${leaves}"></c:set>
								<c:if test="${theLeavesPendingApproval.isEmpty()}">
									<tr>
										<td><a href="#"><button
													class="btn btn-sm btn-danger" type="button" disabled>No pending leaves exists at the moment</button></a></td>
									</tr>
								</c:if>
								<c:forEach items="${leaves}" var="leave">
									<c:set var="status" value="${leave.status}" />
									<tr>
										<td><c:out value="${leave.employeeId}" /></td>
										<td><c:out value="${leave.leaveType}" /></td>
										<td><c:out value="${leave.daysRequested}" /></td>
										<td><c:out value="${leave.startDate}" /></td>
										<td><c:out value="${leave.endDate}" /></td>
										<td><c:out value="${leave.dateOfApplication}" /></td>
										<td><c:out value="${leave.dateOfApproval}" /></td>
										<td><c:out value="${leave.status}" /></td>

										<td><a
											href="edit?leaveId=${leave.leaveId}&employeeId=${leave.employeeId}"
											data-toggle="tooltip" title="Edit your application">Edit</a>&nbsp;

											<c:url var="deleteLink" value="/delete">
												<c:param name="leaveId" value="${leave.leaveId}"></c:param>
											</c:url> <a href="${deleteLink}" data-toggle="tooltip"
											title="Remove your application"><button
													class="btn btn-outline-danger btn-sm " type="button"
													onclick="if(!(confirm('Your Leave application will be deleted,Continue?')))return false;">Delete</button></a>
										</td>



									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<br> <br>
				<div class="card text-center border-success"
					style="max-width: auto;">
					<div class="card-header text-primary">
						<h5>Approved/Rejected Leaves</h5>
					</div>
					<div class="card-body text-success">
						<table class="table table-striped table-bordered"
							style="max-width: auto;">
							<thead>
								<tr>
									<th scope="col">Employee Id</th>
									<th scope="col">leave Type</th>
									<th scope="col">Days Requested</th>
									<th scope="col">Intended Start Date</th>
									<th scope="col">Intended end Date</th>
									<th scope="col">Date of application</th>
									<th scope="col">Date of approval</th>
									<th scope="col">Leave status</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="theLeavesWithReview" value="${leavesWithReview}"></c:set>
								<c:if test="${theLeavesWithReview.isEmpty()}">
									<tr>
										<td><a href="#"><button
													class="btn btn-sm btn-danger" type="button" disabled>No reviewed leaves exists at the moment</button></a></td>
									</tr>
								</c:if>
								<c:forEach items="${leavesWithReview}" var="leaveWithReview">
									<c:set var="status" value="${leave.status}" />
									<c:if test=""></c:if>
									<tr>
										<td><c:out value="${leaveWithReview.employeeId}" /></td>
										<td><c:out value="${leaveWithReview.leaveType}" /></td>
										<td><c:out value="${leaveWithReview.daysRequested}" /></td>
										<td><c:out value="${leaveWithReview.startDate}" /></td>
										<td><c:out value="${leaveWithReview.endDate}" /></td>
										<td><c:out value="${leaveWithReview.dateOfApplication}" /></td>
										<td><c:out value="${leaveWithReview.dateOfApproval}" /></td>
										<td><c:out value="${leaveWithReview.status}" /></td>
										<c:set var="Status" value="${leaveWithReview.status}"></c:set>
										<c:choose>
											<c:when test="${Status=='approved'}">
												<td><c:url var="downloadLink" value="/download">
														<c:param name="leaveId" value="${leaveWithReview.leaveId}"></c:param>
													</c:url> <a href="${downloadLink}" data-toggle="tooltip"
													title="Download a pdf version of your approved leave!"><button
															class="btn btn-outline-success" type="button">Download</button></a></td>
											</c:when>

											<c:otherwise>
												<td>
													<div class="col-md-2">
														<a href="seeRemarks?leaveId=${leaveWithReview.leaveId}"
															data-toggle="tooltip"
															title="View Approver's remarks of your approved leave!"><button
																class="btn btn-outline-warning" type="button">Closed(see
																Remarks)</button></a>
													</div>
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
		</div>
	</div>
</body>
</html>