<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<title>Edit Application</title>
</head>
<body>
	<center>
		<a href="CSGradApply">CS Grad Admission</a> > Edit Application
	</center>
	<form action="EditApplication" method="post">
		<div
			class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
			<table class="table table-hover data-table sort display" border="1"
				cellpadding="2" cellspacing="2">
				<tr>
					<td align="right">Applicant:</td>
					<td><input type="text" class="form-control" name="name"
						value="${entry.name}" /></td>
				</tr>
				<tr>
					<td align="right">Application Received on(mm/dd/yyyy):</td>
					<td><input type="text" class="form-control" name="date"
						value="${entry.dateStr}" /></td>
				</tr>
				<tr>
					<td align="right">GPA:</td>
					<td><input type="text" class="form-control" name="gpa"
						value="${entry.GPA}" /></td>
				</tr>
				<tr>
					<td align="right">Status:</td>
					<td><select class="form-control" name="isStatus">
							<c:forEach items="${statusList}" var="isSelectValue">
								<option value="${isSelectValue}"
									<c:if test="${entry.status == isSelectValue}">
								selected="selected"
							</c:if>>${isSelectValue}</option>

							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right" colspan="2"><input class="btn btn-success"
						type="submit" value="SAVE" name="save" /></td>
				</tr>
			</table>
			<input type="hidden" name="id" value="${entry.id}" />
		</div>
	</form>
</body>
</html>