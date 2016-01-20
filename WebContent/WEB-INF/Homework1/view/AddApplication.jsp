<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<title>Add New Application</title>

</head>
<body>
	<center>
		<a href="CSGradApply">CS Grad Admission</a> > Add Application
	</center>
	<form action="AddApplication" method="post" name="f1">
		<div
			class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
			<div id="tableContainer-1">
				<table class="table table-hover data-table sort display" border="1">
					<tr>
						<td align="right">Applicant:</td>
						<td>
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">@</span> <input
									type="text" name="name" class="form-control"
									placeholder="Applicant Name" aria-describedby="basic-addon1"
									required>
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">Application Received on(M/d/yyyy):</td>
						<td><input type="text" class="form-control" name="date"
							id="datepicker" required /></td>
						<!-- <td><input type="text" class="form-control" name="date" required /></td> -->
					</tr>
					<tr>
						<td align="right">GPA:</td>
						<td><input type="text" class="form-control" name="gpa" /></td>
					</tr>
					<tr>
						<td align="right">Status:</td>
						<td><select class="form-control" id="isStatus"
							name="isStatus">
								<c:forEach items="${statusList}" var="isValue">
									<option value="${isValue}">${isValue}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td align="right" colspan="2"><input class="btn btn-success"
							type="submit" value="ADD" name="add" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>