<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form:form method="post" modelAttribute="user">
        <div>
            <label>Username:</label>
            <form:input name="username" path="username"></form:input>
            <c:if test="${pageContext.request.method=='POST'}">
                <form:errors path="username"/>
            </c:if>
        </div>
        <div>
            <label>Password:</label>
            <form:input name="password" path="password"></form:input>
            <c:if test="${pageContext.request.method=='POST'}">
                <form:errors path="password"/>
            </c:if>
        </div>
        <div>
            <label>Name:</label>
            <form:input name="name" path="name"></form:input>
            <c:if test="${pageContext.request.method=='POST'}">
                <form:errors path="name"/>
            </c:if>
        </div>
        <div>
            <label>Surname:</label>
            <form:input name="surname" path="surname"></form:input>
            <c:if test="${pageContext.request.method=='POST'}">
                <form:errors path="surname"/>
            </c:if>
        </div>
        <div>
            <input type="submit" name="submit" value="submit"/>
        </div>
    </form:form>
</body>
</html>
