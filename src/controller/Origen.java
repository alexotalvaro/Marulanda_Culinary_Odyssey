package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlatoDao;
import model.Plato;

@WebServlet("/Origen")
public class Origen extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Origen() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origen=request.getParameter("origen");
		List<Plato> lista=PlatoDao.getPlatoByOrigen(origen);
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("origen.jsp").forward(request, response);
	}
}
