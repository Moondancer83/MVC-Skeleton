<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <h2>Hoops, something wrong happened.</h2>
    <p>${message}</p>

    <footer>
        <p><a href="${pageContext.request.contextPath}/home">Back to Home</a> </p>
    </footer>
</body>
</html>
