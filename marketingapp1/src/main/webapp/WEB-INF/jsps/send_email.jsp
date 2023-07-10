<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="sendEmail" method="post">
		<table>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input type="text" name="subject"></td>
			</tr>

			<tr>
				<td>message</td>
					<td><input type="text" name="message"></td> 
			</tr>
			<tr>
				<td><input type="submit" value="send"></td>
			</tr>
		</table>
	</form>


</body>
</html>