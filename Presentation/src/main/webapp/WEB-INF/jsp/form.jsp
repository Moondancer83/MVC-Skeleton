<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Form</title>
    <style>
        .error {
            color: red;
        }
        .warnings {
            color: orange;
        }
    </style>
</head>
<body>
    <form:form action="" method="post" commandName="form">
        <table border="0">
            <tr>
                <td></td>
                <td>
                    <ul class="warnings">
                    <c:forEach items="${form.warnings}" var="warning">
                        <li>${warning}</li>
                    </c:forEach>
                    </ul>
                </td>
            </tr>
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
