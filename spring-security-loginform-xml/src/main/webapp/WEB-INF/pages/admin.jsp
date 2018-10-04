<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Admin : ${message}</h1>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

<!-- <a href="./commentsubmit?name=praveen&email=pk@gmail.com&comment=Good">Comment</a> -->

<%-- 
	<form id="comment" action="./commentsubmit?${_csrf.parameterName}=${_csrf.token}" method="post">
--%>
	<form id="comment" action="./commentsubmit" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" id="name" name="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" id="email" name="email" /></td>
			</tr>
			<tr>
				<td>Comment</td>
				<td><input type="text" id="comment" name="comment" /></td>
			</tr>
			<tr>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form>

</body>
</html>