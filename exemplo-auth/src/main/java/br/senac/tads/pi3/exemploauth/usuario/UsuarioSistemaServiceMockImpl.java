/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemploauth.usuario;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistemaServiceMockImpl implements UsuarioSistemaService {

    private static final String SENHA_PADRAO = "abcd1234";

    private static Map<String, UsuarioSistema> mapUsuarios;

    private static boolean initialized = false;

    private PapelService papelService;

    public UsuarioSistemaServiceMockImpl() {
        synchronized (UsuarioSistemaServiceMockImpl.class) {
            if (!initialized) {
                papelService = new PapelServiceMockImpl();
                init();
                initialized = true;
            }
        }
    }

    private void init() {
        mapUsuarios = new LinkedHashMap<>();
        mapUsuarios.put("denver", new UsuarioSistema("denver", "Ricardo Ramos", SENHA_PADRAO,
                Arrays.asList(papelService.findByNome("PEAO"))));
        mapUsuarios.put("tokio", new UsuarioSistema("tokio", "Silene Oliveira", SENHA_PADRAO,
                Arrays.asList(papelService.findByNome("PEAO"))));
        mapUsuarios.put("berlin", new UsuarioSistema("berlin", "Andres de Fonollosa", SENHA_PADRAO,
                Arrays.asList(papelService.findByNome("PEAO"), papelService.findByNome("FODON"))));
        mapUsuarios.put("professor", new UsuarioSistema("professor", "Sergio Marquina", SENHA_PADRAO,
                Arrays.asList(papelService.findByNome("PEAO"), papelService.findByNome("GOD"))));
    }

    @Override
    public UsuarioSistema findByUsername(String username) {
        return mapUsuarios.get(username);
    }
}
