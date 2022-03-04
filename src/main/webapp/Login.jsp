<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import java.io.*%>
<%@page import java.nio.file.*;%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here	</title>
		<link rel = 'stylesheet' type = 'text/css' href = 'style.css'/>
	</head>
	<body>
		<h1>Veuillez vous authentifier</h1>
		<h2><%=new Date() %></h2>
		
		<%
			String login = request.getParameter("txtLogin");
			String password = request.getParameter("txtPassword");
			if (login == null) login = "";
			if (password==null) password = "";
			int i;
	        String line = new String();
	        FileReader file = new FileReader(".htpasswd");
	        BufferedReader buffer = new BufferedReader(file);
	        Path fileLine = Paths.get(".htpasswd");
	        long count = Files.lines(fileLine).count();
	        String login = "ppascal";
	        String mdp = "Monmdpp";
	        
	        String lelogin = "imoundy";
	        final String sep = ":";
	        for (i = 0; i <= count; i++) {

	                line = buffer.readLine();
	                String tab[] = line.split(sep);
	                if (login.equals(tab[0])){
	                  if (mdp.equals(tab[1])){
	                    System.out.println("Connexion réussi !");
	                  }else{
	                    System.out.println("Connexion echoué");
	                  }
	                }
	                
	          }
			
			if(request.getMethod().equals("POST")&& login.equals("bond") && password.equals("007")){
		%>
		<p>Welcome <%= login %></p>
		
		<%}else{ %>
		<form method="post">
			Login : <input name = 'txtLogin' type='text' value = '<%= login %>'/></br>
			Password : <input name = 'txtPassword' type = 'password' value = '<%= password %>'/> <br/>
			<input name = 'btnConnect' type = 'submit'/>
		</form>
		<%} %>
	</body>
</html>