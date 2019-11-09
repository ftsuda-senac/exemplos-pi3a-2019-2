/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploauth.filter;

import br.senac.tads.pi3.exemploauth.usuario.UsuarioSistema;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebFilter(filterName = "AutorizacaoFilter", 
        servletNames = { "HomeServlet" },
        urlPatterns = {"/protegido/*"})
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession sessao = httpRequest.getSession();
        
        if (sessao.getAttribute("usuario") == null) {
            // Usuario nao fez login -> redirecionar usuario para tela de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        
        // Usuario já esta logado -> Recupera objeto da sessao
        UsuarioSistema usuario = 
                (UsuarioSistema) sessao.getAttribute("usuario");
        
        if (verificarAutorizacao(usuario, httpRequest)) {
            // Usuario pode acessar a URL
            chain.doFilter(request, response);
        } else {
            // Usuario não tem permissao necessaria -> Mostra msg de erro.
            httpResponse.sendRedirect(httpRequest.getContextPath()
                    + "/erro-nao-autorizado.jsp");
        }
    }
    
    private boolean verificarAutorizacao(
            UsuarioSistema usuario, 
            HttpServletRequest httpRequest) {
        String urlAcessada = httpRequest.getRequestURI();
        if (urlAcessada.endsWith("/home")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/peao-page") &&
                usuario.verificarPapel("PEAO")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/fodon-page") &&
                usuario.verificarPapel("FODON")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/god-page") &&
                usuario.verificarPapel("GOD")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

}
