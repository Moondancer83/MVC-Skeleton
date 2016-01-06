<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

    <form:form action="" method="post" commandName="form">
        <table border="0">
            <tr>
                <td></td>
                <td>
                    <ul>
                    <c:forEach items="${form.messages}" var="message">
                        <li class="warning">${message}</li>
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

    </tiles:putAttribute>
</tiles:insertDefinition>

