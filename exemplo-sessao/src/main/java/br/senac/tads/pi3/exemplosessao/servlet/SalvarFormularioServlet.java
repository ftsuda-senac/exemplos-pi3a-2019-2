/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplosessao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "SalvarFormularioServlet", urlPatterns = {"/salvar-formulario"})
public class SalvarFormularioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String texto = request.getParameter("texto");
        String resultado = request.getParameter("resultado");

        if ("2".equals(resultado)) {
            // USANDO POST-REDIRECT-GET
            // 1) Mantem o texto na sessaao para ser usado na proxima requisição
            // resultante do redirect (Escopo Flash)
            HttpSession sessao = request.getSession();
            sessao.setAttribute("textoDigitado", texto);
            // 2) Retorna resposta indicando que navegador deve fazer um GET 
            // para o /salvar-formulario
            response.sendRedirect(request.getContextPath() + "/salvar-formulario");
        } else {
            // FLUXO USUAL DO FORWARD
            request.setAttribute("textoDigitado", texto);
            request.getRequestDispatcher("/WEB-INF/jsp/resultado-forward.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp")
                .forward(request, response);
    }

}
