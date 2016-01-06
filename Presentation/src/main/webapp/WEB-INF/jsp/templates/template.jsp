<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Skeleton</title>
</head>
<body>
<h1>Spring MVC Skeleton</h1>

<tiles:insertAttribute name="body"/>

<footer>
    <p><a href="${pageContext.request.contextPath}/home">Back to Home</a></p>
</footer>
</body>
</html>