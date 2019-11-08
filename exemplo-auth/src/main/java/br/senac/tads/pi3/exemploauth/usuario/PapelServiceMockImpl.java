package br.senac.tads.pi3.exemploauth.usuario;

import java.util.LinkedHashMap;
import java.util.Map;

public class PapelServiceMockImpl implements PapelService {

    private static Map<String, Papel> mapPapeis;

    private static boolean initialized = false;

    public PapelServiceMockImpl() {
        synchronized (PapelServiceMockImpl.class) {
            if (!initialized) {
                init();
                initialized = true;
            }
        }
    }

    private void init() {
        mapPapeis = new LinkedHashMap<>();
        mapPapeis.put("PEAO", new Papel("PEAO"));
        mapPapeis.put("FODON", new Papel("FODON"));
        mapPapeis.put("GOD", new Papel("GOD"));
    }

    @Override
    public Papel findByNome(String nomePapel) {
        return mapPapeis.get(nomePapel);
    }
}
