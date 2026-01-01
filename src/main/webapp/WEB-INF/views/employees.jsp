<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employees</title>
</head>
<body>

<h2>Employee List</h2>

<ul>
    <c:forEach var="e" items="${employees}">
        <li>${e.id} - ${e.name}</li>
    </c:forEach>
</ul>

</body>
</html>
