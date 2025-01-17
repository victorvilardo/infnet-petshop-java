package infnet.petshop.com.controllers;

import java.util.Collection;

import infnet.petshop.com.model.Gato;
import infnet.petshop.com.service.GatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GatoController {

    @Autowired
    private GatoService gatoService;

    @GetMapping(value = "/gato/lista")
    public Collection<Gato> obterLista(@RequestParam String orderBy){
        return gatoService.obterLista(orderBy);
    }

    @GetMapping(value =  "/gato/{id}")
    public Gato obterPorId(@PathVariable Integer id) {
        return gatoService.obterPorId(id);
    }

    @PostMapping(value = "/gato/incluir")
    public void incluir(@RequestBody Gato gato) {
        gatoService.incluir(gato);
    }

    @DeleteMapping(value = "/alimenticio/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        gatoService.excluir(id);
    }
}
