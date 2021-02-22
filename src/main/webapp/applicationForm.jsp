<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply</title>
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header text-primary text-center">
				<div class="text-left">
					<a href="index.jsp"><button type="button" class="btn btn-info">Back</button></a>
				</div>
				<h5>Leave Management System</h5>
			</div>
			<div class="card-body">
				<div class="card" style="max-width: auto;">
					<div class="card-header text-primary">
						<h5>Leave Application Form</h5>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-6">
								<div class="card border-success mb-3" style="max-width: auto;">
									<form action="apply" method="post">
										<div class="card-header">
											<h5>Applicants Details:</h5>
										</div>
										<div class="card-body text-primary">
											<div class="form-row">
												<div class="form-group col-md-6">
													<label for="inputEmail4">First Name</label> <input
														type="text" readonly class="form-control-plaintext"
														name="firstName" value="${employee.firstName}">
												</div>
												<div class="form-group col-md-6">
													<label for="inputPassword4">Last Name</label> <input
														type="text" readonly class="form-control-plaintext"
														name="firstName" value="${employee.lastName}">
												</div>
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
							<br> <br>
							<div class="col-sm-6">
								<div class="card border-success mb-3" style="max-width: auto;">
									<div class="card-header">
										<h5>Fill the fields below:</h5>
									</div>
									<br> <input type="hidden" name="leaveId"
										value=${leave.leaveId} >
									<div class="card-body text-primary">
										<div class="form-group">
											<select class="custom-select" id="leaveType" name="leaveType">
												<c:set var="typeOfLeave" value="${leave.leaveType}" />
												<c:choose>
													<c:when test="${typeOfLeave == 'Annual'}">
														<option>Choose a leave Type...</option>
														<option value="Annual" selected>Annual</option>
														<option value="Emergency">Emergency</option>
														<option value="sick">Sick</option>
													</c:when>

													<c:when test="${typeOfLeave == 'Emergency'}">
														<option>Choose a leave Type...</option>
														<option value="Annual">Annual</option>
														<option value="Emergency" selected>Emergency</option>
														<option value="sick">Sick</option>
													</c:when>

													<c:when test="${typeOfLeave == 'sick'}">
														<option>Choose a leave Type...</option>
														<option value="Annual">Annual</option>
														<option value="Emergency">Emergency</option>
														<option value="sick" selected>Sick</option>
													</c:when>

													<c:otherwise>
														<option selected>Choose a leave Type...</option>
														<option value="Annual">Annual</option>
														<option value="Emergency">Emergency</option>
														<option value="sick">Sick</option>
													</c:otherwise>
												</c:choose>

											</select>
										</div>
										<div id="dialog" title="Insufficient Days"
											style="display: none">
											<h6>
												The number of days Requested should be less than <strong>${employee.leaveBalance +1}</strong>
											</h6>
										</div>
										<div class="form-group">
											<label for="daysRequested">No of Days: </label> <input
												type="text" class="form-control" id="daysReqsted"
												name="daysRequested" value="${leave.daysRequested}"
												title="Leave Balance" data-toggle="popover"
												data-placement="top" data-trigger="focus"
												data-content="Requested days should be less than ${employee.leaveBalance +1} . Unless its a sick leave!"
												" onkeyup="myFunction()">

										</div>
										<div class="form-group">
											<label for="startDate">When to start the leave: </label> <input
												type="date" class="form-control" name="startDate"
												value="${leave.startDate}">
										</div>
										<div class="form-group">
											<label for="endDate">When to end the leave: </label> <input
												type="date" class="form-control" name="endDate"
												value="${leave.endDate}" title="" data-toggle="popover"
												data-placement="top" data-trigger="focus"
												data-content="This date should add up to the amount of days Requested!"">
										</div>
										<div class="form-group">
											<label for="address">Address while on leave: </label>
											<textarea type="text" class="form-control" name="address">${leave.address}</textarea>
										</div>
									</div>
								</div>
								<button type="submit" class="btn btn-outline-success">Apply</button>

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

		<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>

		<script>
	function myFunction(){
		  var x = document.getElementById("daysReqsted").value;
		  var y = document.getElementById("leaveType").value;
		  if(${employee.leaveBalance}< x && !(y =="sick")){
			 //alert("The number of days Requested are more than the available amount!!");
			  $( "#dialog" ).dialog({
			      modal: true,
			      buttons: {
			        Ok: function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    }); 
		  }
	}
	</script>
</body>
</html>