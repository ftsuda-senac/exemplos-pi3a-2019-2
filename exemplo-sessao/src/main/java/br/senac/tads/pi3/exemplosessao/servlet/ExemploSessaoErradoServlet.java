package br.senac.tads.pi3.exemplosessao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.tads.pi3.exemplosessao.item.Item;
import br.senac.tads.pi3.exemplosessao.item.ItemSelecionado;
import br.senac.tads.pi3.exemplosessao.item.ItemService;
import br.senac.tads.pi3.exemplosessao.item.ItemServiceMockImpl;

@WebServlet(name = "ExemploSessaoErradoServlet", urlPatterns = { "/exemplo-sessao-errado" })
public class ExemploSessaoErradoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ItemService itemService;

	private List<ItemSelecionado> itensSelecionados;
        
        public ExemploSessaoErradoServlet() {
            itemService = new ItemServiceMockImpl();
            itensSelecionados = new ArrayList<>();
        }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("itens", itemService.findAll());
		request.getRequestDispatcher("/WEB-INF/jsp/exemplo-sessao-errado.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Procura pelo item selecionado a partir do ID.
		String idStr = request.getParameter("idItem");
		int id = Integer.parseInt(idStr);
		Item item = itemService.findById(id);
		itensSelecionados.add(new ItemSelecionado(item));

		request.setAttribute("itensSelecionados", itensSelecionados);
		request.setAttribute("itens", itemService.findAll());
		request.getRequestDispatcher("/WEB-INF/jsp/exemplo-sessao-errado.jsp").forward(request, response);
	}

}
