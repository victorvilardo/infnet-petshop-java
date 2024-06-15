package infnet.petshop.com.service;

import infnet.petshop.com.model.Vendedor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VendedorService {

    private static Map<Integer, Vendedor> mapa = new HashMap<>();
    private static Integer id = 0;

    public void incluir(Vendedor vendedor){
        vendedor.setId(++id);
        mapa.put(vendedor.getId(), vendedor);
    }

    public Collection<Vendedor> obterLista(){
        return mapa.values();
    }
}
