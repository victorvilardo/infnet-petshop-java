package infnet.petshop.com.service;

import infnet.petshop.com.model.Cachorro;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CachorroService {

    private static Map<Integer, Cachorro> mapa = new HashMap<Integer, Cachorro>();
    private static Integer id = 0;

    public void incluir(Cachorro cachorro){
        cachorro.setId(++id);
        mapa.put(cachorro.getId(), cachorro);
    }

    public Collection<Cachorro> obterLista(){
        return mapa.values();
    }
}
