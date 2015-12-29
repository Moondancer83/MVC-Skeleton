<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <form:form action="" method="post" commandName="form">
        <table border="0">
            <tr>
                <td>Field</td>
                <td><form:input path="field" /></td>
                <td><form:errors path="field" cssClass="error"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form:form>
<footer>
    <p><a href="${pageContext.request.contextPath}/home">Back to Home</a> </p>
</footer>
</body>
</html>
