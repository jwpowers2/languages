<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

</head>
<body>

<h1>Languages</h1>
<fieldset>
<legend>Add a movie</legend>
<form:form method="POST" action="/languages/add" modelAttribute="language">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>

    <form:label path="creator">Creator
    <form:errors path="creator"/>     
    <form:input path="creator"/></form:label>
    
    <form:label path="currentVersion">Current Version
    <form:errors path="currentVersion"/>     
    <form:input path="currentVersion"/></form:label>
    
    <input type="submit" value="Submit"/>
</form:form>
</fieldset>
<fieldset>
<legend>All Languages</legend>
<c:forEach items="${languages}" var="l">
<div>
<p>${l.id} <a href="/languages/${l.id}">${l.name}</a> ${l.creator} ${l.currentVersion} <a href="/languages/edit/${l.id}">edit</a><a href="/languages/delete/${l.id}">delete</a></p>
</div>
</c:forEach>
</fieldset>

</body>
</html>