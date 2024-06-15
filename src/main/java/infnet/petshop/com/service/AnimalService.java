package infnet.petshop.com.service;

import infnet.petshop.com.model.Animal;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AnimalService {
    private static Map<Integer, Animal> mapa = new HashMap<Integer, Animal>();
    private static Integer id = 0;

    public void incluir(Animal animal){
        animal.setId(++id);
        mapa.put(animal.getId(), animal);
    }

    public Collection<Animal> obterLista(){
        return mapa.values();
    }

}
