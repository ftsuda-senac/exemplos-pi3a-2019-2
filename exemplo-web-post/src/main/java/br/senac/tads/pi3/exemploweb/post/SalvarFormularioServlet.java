/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploweb.post;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
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
@WebServlet(name = "SalvarFormularioServlet", urlPatterns = {"/formulario/salvar"})
public class SalvarFormularioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String repetirSenha = request.getParameter("repetirSenha");
        String numerSorteStr = request.getParameter("numeroSorte");
        String alturaStr = request.getParameter("altura");
        String pesoStr = request.getParameter("peso");
        String dtNascimentoStr = request.getParameter("dtNascimento");
        String sexoStr = request.getParameter("sexo");
        String[] interesses = request.getParameterValues("interesses");

        request.setAttribute("idAttr", idStr);
        request.setAttribute("nomeAttr", nome);
        request.setAttribute("senhaAttr", senha);
        request.setAttribute("alturaAttr", alturaStr);
        request.setAttribute("dtNascimentoAttr", dtNascimentoStr);
        request.setAttribute("sexoAttr", sexoStr);
        request.setAttribute("interessesAttr", interesses);
        
        // Validacao
        boolean temErros = false;
        // Validacao do nome
        if (nome == null || nome.trim().length() < 1) {
            temErros = true;
            request.setAttribute("erroNome", true);
        }
        // Validacao de senhas iguais
        if (senha != null) {
            if (!senha.contentEquals(repetirSenha)) {
                temErros = true;
                request.setAttribute("erroSenha", true);
            }
        } else {
            if (repetirSenha != null) {
                temErros = true;
                request.setAttribute("erroSenha", true);
            }
        }
        
        if (temErros) {
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/formulario.jsp");
            dispatcher.forward(request, response);
        }

        // Calcula a idade a partir da data de nascimento informada
        LocalDate dtNasc = LocalDate.parse(dtNascimentoStr);
        Period periodo = Period.between(dtNasc, LocalDate.now());
        int idade = periodo.getYears();
        request.setAttribute("idade", idade);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
