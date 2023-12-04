package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlatoDao;
import model.Plato;

/**
 * Servlet implementation class VerDetalle
 */
@WebServlet("/VerDetalle")
public class VerDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerDetalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idPlato=request.getParameter("id");
		int idPlatoInt=Integer.parseInt(idPlato);
		Plato platoSeleccionado=PlatoDao.getPlatoById(idPlatoInt);
		
		request.setAttribute("platoSeleccionado", platoSeleccionado);
		request.getRequestDispatcher("detalle.jsp").forward(request, response);

	}

}
