package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.Cliente;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sId = request.getParameter("id");
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String nascimento = request.getParameter("data");
		String endereco = request.getParameter("endereco");
		
		int id = -1;
		
		try {
			
			id = Integer.parseInt(sId);
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		String acao = request.getParameter("acao");
		
		
		
		Cliente cliente = new Cliente(nome,fone,nascimento,endereco);
		
		if( acao.equals("salvar") ){
			cliente.criar();
			
		}
		if(acao.equals("atualizar")){
			cliente.setId(id);
			cliente.atualizar();
		}
		
		request.setAttribute("cliente", cliente.geraTO() );
		
		RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
		
		view.forward(request, response);
		
	}

}
