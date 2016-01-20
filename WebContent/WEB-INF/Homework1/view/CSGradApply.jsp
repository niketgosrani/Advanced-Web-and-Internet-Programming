<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<title>CS Graduate Admissions</title>
</head>
<body>
	<div class="row text-center" style="height: 120px;">
		<h1>CS Graduate Admission</h1>
		<a href="AddApplication"><span class="glyphicon glyphicon-user"></span>Add
			New Application</a> <br /> <br />
		<table border="1" class="table table-hover data-table sort display">
			<thead>
				<tr>
					<th><c:choose>

							<c:when test="${requestScope.sort!='name'}">
								<a href="CSGradApply?sort=name">Applicant</a>
							</c:when>
							<c:otherwise>
						        Applicant
						    </c:otherwise>
						</c:choose></th>
					<th><c:choose>
							<c:when test="${requestScope.sort!='date'}">
								<a href="CSGradApply?sort=date">Application received on</a>
							</c:when>
							<c:otherwise>
						        Application received on
						    </c:otherwise>
						</c:choose></th>
					<th><c:choose>
							<c:when test="${requestScope.sort!='gpa'}">
								<a href="CSGradApply?sort=gpa">GPA</a>
							</c:when>
							<c:otherwise>
						        GPA
						    </c:otherwise>
						</c:choose></th>
					<th><c:choose>
							<c:when test="${requestScope.sort!='status'}">
								<a href="CSGradApply?sort=status">Status</a>
							</c:when>
							<c:otherwise>
						        Status
						    </c:otherwise>
						</c:choose></th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody id="applications">
				<c:forEach items="${entries}" var="entry">
					<tr>

						<%-- <td align="center">${entry.id }</td> --%>
						<td align="center">${entry.name }</td>
						<td align="center">${entry.dateStr}</td>
						<td align="center">${entry.GPA}</td>
						<td align="center">${entry.status}</td>
						<td align="center">
							<div>
								<a href="EditApplication?id=${entry.id}"> <span
									class="glyphicon glyphicon-edit"></span>Edit
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>