<%@page import="model.ConnectBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Club"%>
<%@page import="model.Abonne"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Clubs de L'ESI</title>
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
<body>
<h3>Inscription au clubs de l'ESI</h3>
<%
ConnectBD cnx = new ConnectBD();
ArrayList<Club> list = cnx.AllClubs();
%>

<div>
<table class="table">
<thead class="thead-primary">
<tr>
<th>N° Club</th>
<th>Nom Club</th>
<th>Nom Président</th>
<th>Date Création</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<% for (Club c : list) {%>
<tr>
<td><%=c.getIdClub()%></td>
<td><%=c.getNomClub()%></td>
<td><%=c.getNomPresident()%></td>
<td><%=c.getDateCreation() %></td>
<%
Abonne a = (Abonne)request.getAttribute("Abonne");
Abonne abn = cnx.FindAbonne(a.getIdClub());
if (abn == null) {
%>
<td><a href="/MIFDAL_Ouissal/inscriptionController?idClub=<%=c.getIdClub()%>">[S'inscrire]</a></td>
<%} 
else {%>
	<td><a href="/MIFDAL_Ouissal/desabonnementController?idClub=<%=c.getIdClub()%>">[Se désabonner]</a></td>
</tr>
<%} }%>
</tbody>
</table>
</div>
<% String msg = (String) request.getAttribute("msg");
if (msg!=null)
{
	if (msg=="Désabonnement avec succès"){
		msg= "Désabonnement avec succès";
		%>	 
	
	 <p style=color:green;><%=msg %></p>
<% } else  {
	 msg ="ERREUR";
%>
	 <p style=color:red;><%=msg %></p>

<% }
}
%>

</body>
</html>