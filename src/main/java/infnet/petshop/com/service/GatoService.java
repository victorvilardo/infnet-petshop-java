package infnet.petshop.com.service;

import infnet.petshop.com.model.Cachorro;
import infnet.petshop.com.model.Gato;
import infnet.petshop.com.repository.CachorroRepository;
import infnet.petshop.com.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GatoService {

    @Autowired
    private GatoRepository gatoRepository;

    public void incluir(Gato gato){
        gatoRepository.save(gato);
    }

    public Collection<Gato> obterLista(){
        return (Collection<Gato>) gatoRepository.findAll();
    }

    public Collection<Gato> obterLista(String orderBy){
        return (Collection<Gato>) gatoRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
    }


    public Gato obterPorId(Integer id) {

        return gatoRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {

        gatoRepository.deleteById(id);
    }

    public long obterQtde() {
        return gatoRepository.count();
    }
}
