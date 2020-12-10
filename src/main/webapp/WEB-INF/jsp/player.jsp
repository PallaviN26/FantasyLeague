<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<body>
    <div>
        <div>
            <h1>Spring Boot JSP Example</h1>
           	
           	<table>      
				<c:forEach items="${result.players}" var="player">
				    <tr>
				    	<td>${player.playerId}</td>
				        <td>${player.playerName}</td>
				        <td>${player.teamId}</td>
				        <td>${player.category}</td>  
				    </tr>
				</c:forEach>
		    </table>
        </div>
    </div>
</body>
</html>