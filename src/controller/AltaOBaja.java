package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlatoDao;
import model.Plato;

@WebServlet("/AltaOBaja")
public class AltaOBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaOBaja() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iden = request.getParameter("id");
		int id = Integer.parseInt(iden);
		Plato plato = PlatoDao.getPlatoById(id);
		if (plato.isBaja() == true) {
			plato.setBaja(false);

		} else {
			plato.setBaja(true);
		}

		PlatoDao.bajaAltaLogica(plato);
		request.getRequestDispatcher("/Login").forward(request, response);

	}
}
