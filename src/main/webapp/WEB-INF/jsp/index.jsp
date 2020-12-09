<!DOCTYPE html>
<html lang="en">
<body>
    <div>
        <div>
            <h1>Spring Boot JSP Example</h1>
            ${message.matchList}
        </div>
    </div>
        <c:forEach var="par" items="${message.matchList}">
        	<c:out value="${par.matchId}"/> <br>
        </c:forEach> 
</body>
</html>