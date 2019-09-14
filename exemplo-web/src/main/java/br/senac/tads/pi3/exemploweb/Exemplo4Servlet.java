/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "Exemplo4Servlet", urlPatterns = {"/exemplo4"})
public class Exemplo4Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Date dataAcesso = new Date();
        request.setAttribute("dtAcesso", dataAcesso);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/exemplo4.jsp");
        dispatcher.forward(request, response);
    }
    
}
