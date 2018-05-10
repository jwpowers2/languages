<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

</head>
<body>

<h1>Language</h1>

<h1>edit ${language.name}</h1>
<fieldset>
<legend>edit a language</legend>
<form:form method="POST" action="/languages/edit/${language.id}" modelAttribute="language">
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


</body>
</html>