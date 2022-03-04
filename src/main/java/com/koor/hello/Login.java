package com.koor.hello;

import java.util.Date;
import java.io.*;
import java.nio.file.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		if (login == null) login = "";
		if (password==null) password = "";
		System.out.println(login + "/"+password);
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("		<head>");
			out.println("			<title>veuillez vous identifer</title>");
			out.println("			<link rel = 'stylesheet' type = 'text/css' href = 'style.css'/>");
			out.println("		</head>");
			out.println("		<body>");
			out.println("			<h1>veuillez vous identifer je test la</h1>");
			out.println("			<form method='post' action = 'login'>");
			out.println("				Login : <input name = 'txtLogin' type='text' value = '"+login+"'/> </br>");
			out.println("				Password : <input name = 'txtPassword' type = 'password' value = '"+password+"'/> <br/>");
			out.println("				<input name = 'btnConnect' type = 'submit'/></br>");
			out.println("			</form>");
			out.println("		</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		int i;
		String line = new String();
		FileReader file = new FileReader("/Users/pierre-richardpascal/eclipse-workspace/helloworld/src/main/java/com/koor/hello/.htpasswd");
		BufferedReader buffer = new BufferedReader(file);
		Path fileLine = Paths.get("/Users/pierre-richardpascal/eclipse-workspace/helloworld/src/main/java/com/koor/hello/.htpasswd");
		long count = Files.lines(fileLine).count();
		final String sep = ":";

		for (i = 0; i <= count; i++) {

			line = buffer.readLine();
			if (line != null) {
				String tab[] = line.split(sep);
				if (login.equals(tab[0])){
					if (password.equals(tab[1])){
						FileReader ficheagent = new FileReader("/Users/pierre-richardpascal/eclipse-workspace/helloworld/src/main/java/com/koor/hello/FicheAgent/" + login +".txt");
		                BufferedReader bufferagent = new BufferedReader(ficheagent);
		                String lineAgent;
		                String nom = null;
		                String prenom = null;
		                String poste = null;
		                String equipement = "<li><input type='checkbox'>";
		                int CptLigne = 0;
		                for (i = 1; i < 15; i++) {
		                    // Si le numéro de la ligne = 4 récupérer la ligne car c'est la qu'on obtient le mdp
		                	lineAgent = bufferagent.readLine();
		                	if (lineAgent != null) {
		                		CptLigne ++;
		                	}
		                    if (i == 1){
		                        nom = lineAgent;
		                    }
		                    if (i == 2){
		                        prenom = lineAgent;
		                    }
		                    if (i == 3){
		                        poste = lineAgent;
		                    }
		                    if (i>4) {
		                    	if(i <= CptLigne) {
		                    		if(lineAgent != null) {
		                    			System.out.println(lineAgent);
		                    			equipement = equipement +"</li><li><input type='checkbox'>"+ lineAgent;
		                    			
		                    		}
		                    		
		                    	}
		                    }
		                    
		                  }
						PrintWriter out = response.getWriter();
						out.println("<!DOCTYPE html>");
						out.println("<html>");
						out.println("		<head>");
						out.println("			<title>Profil</title>");
						out.println("			<link rel = 'stylesheet' type = 'text/css' href = 'style.css'/>");
						out.println("			<style>");
						out.println("			img {width: 200px;height: 200px;\n}");
						out.println(".container {display: flex;flex-wrap: nowrap;justify-content: space-between;}");
						out.println("nav {list-style: none;color: #379ec1;margin: 0 auto;width: 500px;}");
						out.println("header {text-align: center;color: #659224;}");
						out.println(".titre {color: #379ec1;}");
						out.println("#checkboxes ul {margin: 0;list-style: none;vertical-align: center;}");
						out.println("			</style>");
						out.println("		</head>");
						out.println("		<body>");
						out.println("<article>");
						out.println("<div class='container'> ");
						out.println("			<h1>Bonjour, "+nom +" "+ prenom+" les informations de votre journée.</h1>");
						out.println("<img class='image'src = 'photoAgent/"+login+".jpg' height = '200'>");
						out.println("</div> ");
						out.println("</article>");
						
						out.println("<p>Vous occuperez le poste de : "+ poste +" </p>");
						out.println("<p>Vos équipement seront les suivants :</p>");
						out.println("<nav>");
						out.println("<div id = 'checkbox'>");
						out.println("<ul>");
						out.println(equipement);
						out.println("</ul>");
						out.println("</div>");
						out.println("</nav>");
						
						out.println("		</body>");
						out.println("</html>");
						System.out.println("Connexion réussi !");

					}
				}


			}
			// TODO Auto-generated method stub
		}

	}
}
