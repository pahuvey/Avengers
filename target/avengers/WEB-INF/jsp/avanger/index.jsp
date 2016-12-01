<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/avengers/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
   
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
	<H4>
		Liste des Avangers <span class="badge"><c:out value="${list.size()}" /></span>
	</H4>
	<c:choose>
	
	<c:when test="${list.size()>0}">
		<table class="table table-bordered table-striped table-inverse">
		<thead>
			<tr><th>Nom</th><th>Prenom</th><th>Alias</th><th>Niveau</th><th>Agent</th><th></th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="avanger">
    		<tr>
    			<td><img src="${avanger.imageBase64}" width="50" height="50"></img></td>
    			<td>${avanger.lastName}</td>
    			<td>${avanger.firstName}</td>
    			<td>${avanger.alias}</td>
    			<td>${avanger.power}</td>
    			<td>${avanger.agent.firstName} ${avanger.agent.lastName}</td>
    			
    			<td> 
    			<form action="/avengers/app/avanger/${avanger.id}/delete" method="post">
    				<button class="btn btn-danger glyphicon glyphicon-remove" type="submit"></button></td></form>
    				<td><form action="/avengers/app/avanger/${avanger.id}/edit" method="POST"><button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></button></form></td>
    				<td><a href="/avengers/app/avanger/${avanger.id}/uploadPhoto" class="btn btn-info" role="button"><span class="glyphicon glyphicon-camera"></span></a>
    				
    				</td>
    				
    			
    		</tr>
		</c:forEach>
		</tbody>
		</table>
		
	</c:when>
	<c:otherwise>
		<h5>La liste des avangers est vide</h5>
	</c:otherwise>
</c:choose>
		
</body>
</html>





