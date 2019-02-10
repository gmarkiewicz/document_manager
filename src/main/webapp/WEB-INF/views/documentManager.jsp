<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Document Manager</title>
</head>
<body>
    <h1>Document Manager</h1>
    <p>Welcome <sec:authentication property="principal.username"/>!</p>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created by</th>
            <th>Last edited</th>
            <sec:authorize access="hasAnyAuthority('MODERATOR', 'ADMIN')">
                <th></th>
            </sec:authorize>
        </tr>
            <c:forEach items="${documentList}" var="document">
                <tr>
                <td>${document.id}</td>
                <td>${document.name}</td>
                <td>${document.description}</td>
                <td>${document.user.username}</td>
                <td>${document.lastEdited}</td>
                <td>
                    <sec:authorize access="hasAnyAuthority('MODERATOR', 'ADMIN')">
                        <button type="submit" value="Edit">Edit</button>
                    </sec:authorize>
                    <sec:authorize access="hasAuthority('ADMIN')">
                        <button type="submit" value="Delete">Delete</button>
                    </sec:authorize>
                </td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
