package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Abonne;
import model.ConnectBD;

/**
 * Servlet implementation class inscriptionController
 */
@WebServlet("/inscriptionController")
public class inscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscriptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomAbonne = request.getParameter("Nom");
		String prenomAbonne = request.getParameter("Prénom");
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
		String date = simpleDateFormat.format(new Date());
		ConnectBD cnx = new ConnectBD();
		try {
			boolean result = cnx.addAbonne(new Abonne(nomAbonne, prenomAbonne, date));
			String msg;
			if (result == true) {
				msg = "L'abonnée à été ajouté avec succés";
			}
			else {
				msg = "Erreur, veuillez vérifier vos données";
			}
			
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/inscription.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.toString();
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
