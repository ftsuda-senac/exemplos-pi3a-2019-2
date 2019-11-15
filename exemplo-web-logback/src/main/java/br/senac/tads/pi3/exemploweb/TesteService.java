/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fernando.tsuda
 */
public class TesteService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TesteService.class);
    
    public void teste() {
        LOGGER.error("***** CHAMOU TesteService.teste() - ERROR");
        LOGGER.warn("***** CHAMOU TesteService.teste() - WARN");
        LOGGER.info("***** CHAMOU TesteService.teste() - INFO");
        LOGGER.debug("***** CHAMOU TesteService.teste() - DEBUG");
        LOGGER.trace("***** CHAMOU TesteService.teste() - TRACE");
    }
    
}
