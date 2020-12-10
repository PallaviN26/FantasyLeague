<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<body>
    <div>
        <div>
            <h1>Spring Boot JSP Example</h1>
           	
           	<table>      
				<c:forEach items="${message.matchList}" var="match">
				    <tr>
				    	<td>${match.matchId}</td>
				        <td>${match.firstId}</td>
				        <td>${match.secondId}</td>
				        <td>${match.venue}</td>  
				    </tr>
				</c:forEach>
		    </table>
        </div>
    </div>
</body>
</html>