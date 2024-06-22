package infnet.petshop.com.service;

import infnet.petshop.com.model.Gato;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GatoService {

    private static Map<Integer, Gato> mapa = new HashMap<Integer, Gato>();
    private static Integer id = 0;

    public void incluir(Gato gato){
        gato.setId(++id);
        mapa.put(gato.getId(), gato);
    }

    public Collection<Gato> obterLista(){
        return mapa.values();
    }


    public Gato obterPorId(Integer id) {
        return mapa.get(id);
    }

    public void excluir(Integer id) {
        mapa.remove(id);
    }
}
