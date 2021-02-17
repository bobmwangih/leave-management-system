<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Success</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$("#myModal").modal('show');
	});
</script>
</head>
<body>
	<div class="card text-center border-success" style="max-width: auto;">
		<div class="card-body ">
			<div id="myModal" class="modal fade border-success">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content border-success">
						<div class="modal-header">
							<h4 class="modal-title text-success">Approver's Remarks</h4>
						<!-- 	<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button> -->
						</div>
						<div class="modal-body text-success">
							<div class="container">
								<div class="form-group">
									<textarea type="text" class="form-control" > ${message} </textarea>
								</div>
							</div>
							<a href="viewApplication.jsp"><button type="button"
									class="btn btn-info">Back</button></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>