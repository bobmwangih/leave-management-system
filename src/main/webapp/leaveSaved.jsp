<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Info</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function(){
		$("#myModal").modal('show');
	});
</script>
</head>
<body>
<div class="card text-center border-success" style="max-width: auto;">
<div class="card-body ">
<div id="myModal" class="modal fade border-success ">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"></h5>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
				<p>${message}</p>
				<c:set var="origin" value="${origin}"></c:set>
				<c:choose>
					<c:when test="${origin == 'delete'}">
						<a href="viewApplication.jsp"><button type="button" class="btn btn-info">Back</button></a>
					</c:when>
					<c:when test="${origin == 'insufficientDays'}">
						<a href="applicationForm.jsp"><button type="button" class="btn btn-info">Back</button></a>
					</c:when>
					<c:otherwise>
                    <a href="index.jsp"><button type="button" class="btn btn-info">Home</button></a>
					</c:otherwise>
				</c:choose>
            </div>
        </div>
    </div>
    </div>
</div>
</div>
</body>
</html>