<html>
<head>
<title>test</title>
</head>
<body version="1.0">
<c:out2 value="1 ${user.userName}"></c:out2>
<c:out2>2 <div>${user.userName}</div></c:out2>
<c:if test="${util.notEmpty(userList)}">userList is not empty !</c:if>
<c:out id="1" escapeXml="true"><div><c:out id="2" value="${user.userName}"></c:out></div></c:out>
</body>
</html>