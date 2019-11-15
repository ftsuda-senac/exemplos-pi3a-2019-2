/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplochart;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ChartDataServlet", urlPatterns = {"/chart-data"})
public class ChartDataServlet extends HttpServlet {
    
    // https://flatuicolors.com/palette/defo
    private static final String[] COLORS = {"rgba(26, 188, 156, 1.0)", "rgba(52, 152, 219, 1.0)", "rgba(155, 89, 182, 1.0)",
        "rgba(241, 196, 15,1.0)", "rgba(231, 76, 60,1.0)"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SecureRandom random = new SecureRandom();
        
        List<Dataset> datasets = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            Dataset ds = new Dataset();
            ds.setLabel("Dataset " + i);
            ds.setStack("stack0");
            ds.setBackgroundColor(COLORS[i]);
            ds.setBorderColor(COLORS[i]);
            List<BigDecimal> data = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                data.add(new BigDecimal(random.nextInt(100)));
            }
            ds.setData(data);
            datasets.add(ds);
        }
        
        // Preparar resposta
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        //response.addHeader("Access-Control-Allow-Origin", "*");
        
        // Jackson 2
        ObjectMapper mapper = new ObjectMapper();
        try (PrintWriter out = response.getWriter()) {
            out.print(mapper.writeValueAsString(datasets));
        }

    }

}
