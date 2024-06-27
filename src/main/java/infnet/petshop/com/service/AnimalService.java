package infnet.petshop.com.service;

import infnet.petshop.com.model.Animal;
import infnet.petshop.com.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public void incluir(Animal animal){
        try {
            animalRepository.save(animal);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    public Collection<Animal> obterLista(){
        return (Collection<Animal>) animalRepository.findAll();
    }


    public Animal obterPorId(Integer id) {

        return animalRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {

        animalRepository.deleteById(id);
    }

    public long obterQtde() {
        return animalRepository.count();
    }


    public Collection<Animal> obterListaPorVendedor(Integer id){
        return (Collection<Animal>) animalRepository.findByVendedorId(id);
    }
}
