<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review</title>
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
<% response.setHeader("Cache-Control", "no-cache"); 
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expire",0);
	
%>
	<div class="container">
		<div class="card">
			<div class="card-header text-primary text-center">
				<h5>Leave Management System Approver's Module</h5>
			</div>
			<div class="card-body">

				<div class="text-right">
					<a href="logOut"><button type="button" class="btn btn-info">log
							out</button></a>
				</div>
				<div class="text-left">
					<a href="back"><button type="button" class="btn btn-info">Back</button></a>
				</div>
				<br> <br>
				<div class="card" style="max-width: auto;">
					<div class="card-header text-primary">
						<h5>Leave Approval Form</h5>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<div class="card border-success mb-3" style="max-width: auto;">
									<form action="review" method="post">
										<div class="card-header">
											<h5>Applicants Details:</h5>
										</div>
										<div class="card-body text-primary">
											<div class="form-group">
												<label for="firstName">Name: </label> <input type="text"
													readonly class="form-control-plaintext" name="firstName"
													value="${employee.firstName} ${employee.lastName}">
											</div>
											<div class="form-group">
												<label for="employeeId">Employee Id: </label> <input
													type="text" readonly class="form-control-plaintext"
													name="employeeId" value="${employee.employeeId}">
											</div>
											<div class="form-group">
												<label for="email">Email: </label> <input type="email"
													readonly class="form-control-plaintext" name="email"
													value="${employee.email}">
											</div>
											<div class="form-group">
												<label for="leaveBalance">Leave Balance</label> <input
													type="text" readonly class="form-control-plaintext"
													name="leaveBalance" value="${employee.leaveBalance}">
											</div>
										</div>
								</div>
							</div>
							<br>
							<div class="col-sm-6">
								<div class="card border-success mb-3" style="max-width: auto;">
									<div class="card-header">
										<h5>
											<h5>Leave Details:</h5>
										</h5>
									</div>
									<br> <input type="hidden" name="leaveId"
										value="${leave.leaveId}" readOnly="readonly">
									<div class="card-body text-primary">
										<div class="form-group">
											<label for="leaveType">Leave Type: </label> <input
												type="text" readonly class="form-control-plaintext"
												name="leaveType" value="${leave.leaveType}">
										</div>
										<div class="form-group">
											<label for="daysRequested">Days requested: </label> <input
												type="text" readonly class="form-control-plaintext"
												name="daysRequested" value="${leave.daysRequested}">
										</div>
										<div class="form-group">
											<label for="startDate">Intended leave Start Date: </label> <input
												type="text" readonly class="form-control-plaintext"
												name="startDate" value="${leave.startDate}">
										</div>
										<div class="form-group">
											<label for="endDate">Intended leave End Date: </label> <input
												type="text" readonly class="form-control-plaintext"
												name="
										endDate" value="${leave.endDate}">
										</div>
										<div class="form-group">
											<label for="address">Address while on leave: </label> <input
												type="text" readonly class="form-control-plaintext"
												name="address" value="${leave.address}">
										</div>
										<div class="form-group">
											<label for="dateOfApplication">Date of application: </label>
											<input type="text" readonly class="form-control-plaintext"
												name="dateOfApplication" value="${leave.dateOfApplication}">
										</div>
										<div class="form-group">
											<label for="status">Leave Status: </label> <input type="text"
												readonly class="form-control-plaintext" name="status"
												value="${leave.status}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="card border-success mb-3" style="max-width: auto;">
							<div class="card-header">
								<h5>Fill Below:</h5>
							</div>
							<div class="card-body text-primary">
								<div class="form-group">
									<select class="custom-select" name="reviewType">
										<option selected>Choose to Approve/Reject...</option>
										<option value="approved">Approve</option>
										<option value="declined">Reject</option>
									</select>
								</div>
								<div class="form-group">
									<label for="remarks">Remarks: </label>
									<textarea type="text" class="form-control" name="remarks" placeholder="person to take charge/reasons for decline"></textarea>
								</div>
								<div class="form-group">
									<label for="supervisorId">Approver Employee Id: </label> <input
										type="text" class="form-control" name="supervisorId"
										value="k-Supervisor">
								</div>
								<button type="submit" class="btn btn-outline-success">Review</button>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>