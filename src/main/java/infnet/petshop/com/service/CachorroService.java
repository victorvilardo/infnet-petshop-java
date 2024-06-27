package infnet.petshop.com.service;

import infnet.petshop.com.model.Animal;
import infnet.petshop.com.model.Cachorro;
import infnet.petshop.com.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CachorroService {

    @Autowired
    private CachorroRepository cachorroRepository;

    public void incluir(Cachorro cachorro){
        cachorroRepository.save(cachorro);
    }

    public Collection<Cachorro> obterLista(){
        return (Collection<Cachorro>) cachorroRepository.findAll();
    }


    public Cachorro obterPorId(Integer id) {

        return cachorroRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {

        cachorroRepository.deleteById(id);
    }

    public long obterQtde() {
        return cachorroRepository.count();
    }

    public Collection<Cachorro> obterListaPorPorte(String porte){
        return (Collection<Cachorro>) cachorroRepository.findByPorte(porte);
    }
}
