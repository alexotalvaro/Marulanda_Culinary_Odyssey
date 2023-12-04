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
 * Servlet implementation class EditarPlato
 */
@WebServlet("/EditarPlato")
public class EditarPlato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarPlato() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ident = request.getParameter("id");
		int id = Integer.parseInt(ident);

		Plato plato = PlatoDao.getPlatoById(id);

		request.setAttribute("plato", plato);

		request.getRequestDispatcher("editar.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iden=request.getParameter("id");
		int id=Integer.parseInt(iden);
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		double precioD = Double.parseDouble(precio);
		String origen = request.getParameter("origen");
		String imagen = request.getParameter("imagen");
		String localizacion = request.getParameter("opcion");

		Plato plato = new Plato(id, nombre, descripcion, precioD, imagen, localizacion, origen, false);
		PlatoDao.editarPlato(plato);
		request.getRequestDispatcher("/Login").forward(request, response);

	}

}
