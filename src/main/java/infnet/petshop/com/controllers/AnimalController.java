package infnet.petshop.com.controllers;

import infnet.petshop.com.model.Animal;
import infnet.petshop.com.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/animal/lista")
    public Collection<Animal> obterLista(){
        return animalService.obterLista();
    }

    @GetMapping(value =  "/animal/{id}")
    public Animal obterPorId(@PathVariable Integer id) {
        return animalService.obterPorId(id);
    }

    @PostMapping(value = "/animal/incluir")
    public void incluir(@RequestBody Animal animal) {
        animalService.incluir(animal);
    }

    @DeleteMapping(value = "/animal/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        animalService.excluir(id);
    }
}
