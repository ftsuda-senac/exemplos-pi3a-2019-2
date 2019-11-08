/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplosessao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.tads.pi3.exemplosessao.item.Item;
import br.senac.tads.pi3.exemplosessao.item.ItemSelecionado;
import br.senac.tads.pi3.exemplosessao.item.ItemService;
import br.senac.tads.pi3.exemplosessao.item.ItemServiceMockImpl;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ExemploSessaoServlet", urlPatterns = {"/exemplo-sessao"})
public class ExemploSessaoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ItemService itemService;

    public ExemploSessaoServlet() {
        itemService = new ItemServiceMockImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("itens", itemService.findAll());
        request.getRequestDispatcher("/WEB-INF/jsp/exemplo-sessao.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();

        // Verifica se já existe atributo itensSelecionados na sessao
        // Se nao existir cria um novo
        if (sessao.getAttribute("itensSelecionados") == null) {
            sessao.setAttribute("itensSelecionados", new ArrayList<ItemSelecionado>());
        }

        // Recupera a lista de itens selecionados da sessao
        List<ItemSelecionado> itensSelecionados = (List<ItemSelecionado>) sessao.getAttribute("itensSelecionados");

        // Procura pelo item selecionado a partir do ID.
        String idStr = request.getParameter("idItem");
        int id = Integer.parseInt(idStr);
        Item item = itemService.findById(id);
        itensSelecionados.add(new ItemSelecionado(item));

        // Reapresenta tela para escolher item
        response.sendRedirect(request.getContextPath() + "/exemplo-sessao");
    }
}
