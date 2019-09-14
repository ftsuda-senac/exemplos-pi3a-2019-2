/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ExemploParametroServlet", urlPatterns = {"/exemplo-parametro"})
public class ExemploParametroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String idadeStr = request.getParameter("idade");
        String info = request.getParameter("info");
        
        int idade = Integer.parseInt(idadeStr);
        
        request.setAttribute("nomeAttr", nome);
        request.setAttribute("idadeAttr", idade);
        request.setAttribute("infoAttr", info);
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher(
                        "/WEB-INF/exemplo-parametro.jsp");
        dispatcher.forward(request, response);

    }

}
