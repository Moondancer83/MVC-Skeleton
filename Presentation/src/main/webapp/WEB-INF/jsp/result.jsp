<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form result</title>
</head>
<body>
<h1>${message}</h1>
<p>Data: ${result.field}</p>
<p>Created at: ${result.answerDate}</p>

<footer>
    <p><a href="${pageContext.request.contextPath}/home">Back to Home</a> </p>
</footer>
</body>
</html>
