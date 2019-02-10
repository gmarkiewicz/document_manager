<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<form:form method="POST" modelAttribute="documentForm" enctype="multipart/form-data">
    <div>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
    </div>
    <div>
        <form:label path="description">Description</form:label>
        <form:input path="description"/>
    </div>
    <div>

        <form:label path="pdfFile">Document</form:label>
    </div>
    <div>
        <input type="file" name="file"></input>
        <input type="submit" value="Add Document"/>
    </div>
</form:form>
</body>
</html>
