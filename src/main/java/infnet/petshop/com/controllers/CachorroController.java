package infnet.petshop.com.controllers;

import infnet.petshop.com.model.Cachorro;
import infnet.petshop.com.service.CachorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CachorroController {

    @Autowired
    private CachorroService cachorroService;

    @GetMapping(value = "/cachorro/lista")
    public Collection<Cachorro> obterLista(){
        return cachorroService.obterLista();
    }

    @GetMapping(value =  "/cachorro/{id}")
    public Cachorro obterPorId(@PathVariable Integer id) {
        return cachorroService.obterPorId(id);
    }

    @PostMapping(value = "/cachorro/incluir")
    public void incluir(@RequestBody Cachorro cachorro) {
        cachorroService.incluir(cachorro);
    }

    @DeleteMapping(value = "/cachorro/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        cachorroService.excluir(id);
    }
}
