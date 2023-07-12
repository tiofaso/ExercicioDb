package tools;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer,String> menu = new HashMap<Integer,String>();

    public void mostraMenu(){//Menu padrão do programa

        menu.put(1,"Inserir nome");
        menu.put(2,"Atualizar nome");
        menu.put(3, "Apagar nome");
        menu.put(4,"Mostrar nomes");

        System.out.println("Escolha uma das opções abaixo:");
        for (Integer key : menu.keySet()) {
            System.out.println(key + " - " + menu.get(key));
        }
    }
}
