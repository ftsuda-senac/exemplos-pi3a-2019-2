/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploauth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "PeaoServlet", urlPatterns = {"/protegido/peao-page"})
public class PeaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("titulo", "Página do PEAO");
        request.setAttribute("msg", "Usuário logado possui papel \"PEAO\"");
        request.getRequestDispatcher("/WEB-INF/jsp/resultado-protegido.jsp")
                .forward(request, response);
    }


}
