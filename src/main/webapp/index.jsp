<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Home</title>

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
		<div class="card text-center border-success ">
			<div class="card-heade text-primary">
				<div class="container">
					<div class="row justify-content-end">

						<div class="col-md-2">
							<button type="submit" class="btn btn-outline-primary btn-sm "
								data-target="#loginModal" data-toggle="modal">Review
								Application</button>

							<div class="modal fade border-success" tabindex="-1" id="loginModal">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content border-success">
										<div class="modal-header">
											<h4 class="modal-title text-primary">Approver Login</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<div class="container">
												<form action="ask-to-review" method="post">
													<div class="form-group">
														<label for="userName">UserName: </label> <input
															type="text" class="form-control" name="userName"
															value="patrick">
													</div>
													<div class="form-group">
														<label for="password">Password: </label> <input
															type="text" class="form-control" name="password"
															value="patrick123">
													</div>
													<button type="submit" class="btn btn-outline-success">Log
														in</button>
												</form>

											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div>



						<div class="col-md-2">
							<button type="submit" class="btn btn-outline-success btn-sm "
								data-target="#viewApplicationModal" data-toggle="modal">View
								Application</button>

							<div class="modal fade" tabindex="-1" id="viewApplicationModal">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">Input your Employee Id</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<form action="ask-to-view-application" method="post">

												<div class="form-group">
													<div>
														<input type="text" class="form-control" name="employeeId"
															placeholder="Employee Id" value="t33265896">
														<button type="submit" class="btn btn-outline-success">Check</button>
													</div>

												</div>
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<br> <br>
			</div>
			<div class="card-body text-success">
				<form action="ask-to-apply" method="post">

					<div class="form-group">
						<div>
							<input type="text" class="form-control" name="employeeId"
								placeholder="Employee Id" value="t33265896">
							<button type="submit" class="btn btn-outline-success">Apply</button>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>