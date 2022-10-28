package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ConnectBD;

/**
 * Servlet implementation class desabonnementController
 */
@WebServlet("/desabonnementController")
public class desabonnementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public desabonnementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idClub = Integer.parseInt(request.getParameter("idClub"));
		ConnectBD cnx = new ConnectBD();
		String msg;
		try {
			boolean result = cnx.deleteAbonne(idClub);
			if (result) {
				msg = "Désabonnement avec succès";
			}
			else {
				msg = "ERREUR!";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
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
