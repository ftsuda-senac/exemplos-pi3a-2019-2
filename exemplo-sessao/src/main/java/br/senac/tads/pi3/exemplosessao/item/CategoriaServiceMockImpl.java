/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplosessao.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author ftsuda
 */
public class CategoriaServiceMockImpl implements CategoriaService {

	private static Map<Integer, Categoria> mapItens;

	private static int sequenciaId;

	private static boolean initialized = false;

	public CategoriaServiceMockImpl() {
		synchronized (CategoriaServiceMockImpl.class) {
			if (!initialized) {
				init();
				initialized = true;
			}
		}
	}

	private void init() {
		sequenciaId = 0;
		mapItens = new ConcurrentHashMap<>();
		mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 1"));
		mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 2"));
		mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 3"));
		mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 4"));
		mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 5"));
	}

	@Override
	public List<Categoria> findAll() {
		return new ArrayList<>(mapItens.values());
	}

	@Override
	public Categoria findById(Integer id) {
		return mapItens.get(id);
	}

}
