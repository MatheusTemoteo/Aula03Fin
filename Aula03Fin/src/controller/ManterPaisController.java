package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPaisController.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pPais = request.getParameter("pais");
		
		Cliente cliente = new Cliente();
		cliente.setPais(pPais);
		
		ClienteService cs = newClienteService();
		cs.criar(cliente);
		cliente = cs.carregar(cliente.getId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>ClienteCadastrado</title></head><body>");
		out.println( "id: "+cliente.getId()+"<br>");
		out.println( "nome: "+cliente.getPais()+"<br>");
	}

	private ClienteService newClienteService() {
		// TODO Auto-generated method stub
		return null;
	}

}
