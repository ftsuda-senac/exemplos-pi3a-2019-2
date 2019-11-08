package br.senac.tads.pi3.exemplosessao.item;

import java.util.List;
import java.util.Set;

public class ItemMain {

    private ItemService itemService = new ItemServiceMockImpl();

    private String listCategorias(Set<Categoria> categorias) {
        if (categorias != null && !categorias.isEmpty()) {
            StringBuilder strBuilder = new StringBuilder();
            for (Categoria cat : categorias) {
                strBuilder.append(cat.getNome());
                strBuilder.append(", ");
            }
            return strBuilder.substring(0, strBuilder.length() - 2);
        }
        return "";
    }

    public void run(String[] args) {
        List<Item> itens = itemService.findAll();
        if (itens != null && !itens.isEmpty()) {
            for (Item item : itens) {
                System.out.println(String.format("Item id=%d, nome=%s, valor=%d, dataHora=%s, categorias=[%s]",
                        item.getId(), item.getNome(), item.getValor(), item.getDataHora(),
                        listCategorias(item.getCategorias())));
            }
        }
    }

    public static void main(String[] args) {
        ItemMain main = new ItemMain();
        main.run(args);
    }
}
