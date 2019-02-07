<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sp" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="messages"/>
<fmt:message key="message.password" var="noPass"/>
<fmt:message key="message.username" var="noUser"/>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript">
        function validate() {
            if (document.f.username.value =="" && document.f.password.value =="") {
                alert("{noUser} and ${noPass}");
                document.f.username.focus();
                return false;
            }
            if (document.f.username.value == "") {
                alert("${noUser}");
                document.f.username.focus();
                return false;
            }
            if (document.f.password.value == "") {
                alert("${noPass}");
                document.f.password.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<div th:if="${param.message != null}" class="alert alert-info" th:text="${param.message[0]}">message</div>
<div th:if="${param.error != null}" class="alert alert-danger" th:text="${session[SPRING_SECURITY_LAST_EXCEPTION]}">error</div>
    <form name="f" action="documentManager" method="post" onsubmit="return validate();">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="submit"/></td>
            </tr>
        </table>
    </form>
<c:if test="${param.regSucc == true}">
    <div id="status">
        <spring:message code="message.regSucc"></spring:message>
    </div>
</c:if>
<c:if test="${param.regError == true}">
    <div id="regError">
        <spring:message code="message.regError"></spring:message>
    </div>
</c:if>
<c:if test="${param.error !=null}">
    <div id="error">
        <spring:message code="message.badCredentials"></spring:message>
    </div>
</c:if>
</body>
</html>
