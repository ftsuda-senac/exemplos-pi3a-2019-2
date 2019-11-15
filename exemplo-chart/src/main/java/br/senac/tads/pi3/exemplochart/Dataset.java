/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplochart;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class Dataset {
    
    private String label;
    
    private String stack;
    
    private String backgroundColor;
    
    private String borderColor;
    
    private List<BigDecimal> data;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public List<BigDecimal> getData() {
        return data;
    }

    public void setData(List<BigDecimal> data) {
        this.data = data;
    }
    
}
