<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Club"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">
</head>
<body class="container">

<form class="form-group" action="/MIFDAL_Ouissal/inscriptionController" method="get">
<table>
<% Club c = (Club)request.getAttribute("Club"); %>

<tr><td>N° Club</td></tr>
<tr><td><input class="form-control" type="text" value=<%=c.getIdClub()%> disabled="disabled"></td></tr>
<tr><td>Nom</td></tr>
<tr><td><input class="form-control" type="text" placeholder="Nom abonné"></td></tr>
<tr><td>Prénom</td></tr>
<tr><td><input class="form-control" type="text" placeholder="Prénom abonné"></td></tr>
<tr><td><button class="btn btn-primary" type="submit">S'inscrire</button></td></tr>

</table>
</form>

<% String msg = (String) request.getAttribute("msg");
if (msg!=null)
{
	if (msg=="L'abonnée à été ajouté avec succés"){
		msg= " L'abonnement a été ajouté à la base de données";
		%>	 
	
	 <p style=color:green;><%=msg %></p>
<% } else  {
	 msg ="Erreur lors de l'inscription";
%>
	 <p style=color:red;><%=msg %></p>

<% }
}
%>

</body>
</html>