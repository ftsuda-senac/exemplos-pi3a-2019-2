/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "LogServlet", urlPatterns = {"/log"})
public class LogServlet extends HttpServlet {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LogServlet.class);
    
    private TesteService service = new TesteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.error("***** ENTROU EM /log - ERROR");
        LOGGER.warn("***** ENTROU EM /log - WARN");
        LOGGER.info("***** ENTROU EM /log - INFO");
        LOGGER.debug("***** ENTROU EM /log - DEBUG");
        LOGGER.trace("***** ENTROU EM /log - TRACE");
        service.teste();
        request.getRequestDispatcher("/WEB-INF/log.jsp").forward(request, response);
    }
}
