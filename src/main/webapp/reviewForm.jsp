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
	<div class="container">
		<a href="index.jsp"><button type="button" class="btn btn-info">Back</button></a>
		<br> <br>

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
									class="form-control" name="firstName"
									value="${employee.firstName} ${employee.lastName}"
									readOnly="readonly">
							</div>
							<div class="form-group">
								<label for="employeeId">Employee Id: </label> <input type="text"
									class="form-control" name="employeeId"
									value="${employee.employeeId}" readOnly="readonly">
							</div>
							<div class="form-group">
								<label for="email">Email: </label> <input type="email"
									class="form-control" name="email" value="${employee.email}"
									readOnly="readonly">
							</div>
							<div class="form-group">
								<label for="leaveBalance">Leave Balance</label> <input
									type="text" class="form-control" name="leaveBalance"
									value="${employee.leaveBalance}" readOnly="readonly">
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
							<label for="leaveType">Leave Type: </label> <input type="text"
								class="form-control" name="leaveType" value="${leave.leaveType}"
								readOnly="readonly">
						</div>
						<div class="form-group">
							<label for="daysRequested">Days requested: </label> <input
								type="text" class="form-control" name="daysRequested"
								value="${leave.daysRequested}" readOnly="readonly">
						</div>
						<div class="form-group">
							<label for="startDate">Intended leave Start Date: </label> <input
								type="text" class="form-control" name="startDate"
								value="${leave.startDate}" readOnly="readonly">
						</div>
						<div class="form-group">
							<label for="endDate">Intended leave End Date: </label> <input
								type="text" class="form-control" name=""
								endDate""
					value="${leave.endDate}" readOnly="readonly">
						</div>
						<div class="form-group">
							<label for="address">Address while on leave: </label> <input
								type="text" class="form-control" name="address"
								value="${leave.address}" readOnly="readonly">
						</div>
						<div class="form-group">
							<label for="dateOfApplication">Date of application: </label> <input
								type="text" class="form-control" name="dateOfApplication"
								value="${leave.dateOfApplication}" readOnly="readonly">
						</div>
						<div class="form-group">
							<label for="status">Leave Status: </label> <input type="text"
								class="form-control" name="status" value="${leave.status}"
								readOnly="readonly">
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
					<textarea type="text" class="form-control" name="remarks"></textarea>
				</div>
				<div class="form-group">
					<label for="supervisorId">Employee Id: </label> <input type="text"
						class="form-control" name="supervisorId" value="k-Supervisor">
				</div>
				<button type="submit" class="btn btn-outline-success">Review</button>
			</div>
		</div>
		</form>
	</div>
</body>
</html>