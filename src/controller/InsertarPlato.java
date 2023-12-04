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
 * Servlet implementation class InsertarPlato
 */
@WebServlet("/InsertarPlato")
public class InsertarPlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarPlato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nombre=request.getParameter("nombre");
		String descripcion=request.getParameter("descripcion");
		String precio=request.getParameter("precio");
		double precioD=Double.parseDouble(precio);
		String origen=request.getParameter("origen");
		String imagen=request.getParameter("imagen");
		String localizacion=request.getParameter("opcion");
		
		Plato plato = new Plato(1,nombre,descripcion,precioD,imagen,localizacion,origen,false);
		
		boolean insertado=PlatoDao.insertarPlato(plato);
		
		
		request.getRequestDispatcher("/Admin").forward(request, response);
		
	}

}
