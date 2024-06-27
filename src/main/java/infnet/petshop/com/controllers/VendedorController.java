package infnet.petshop.com.controllers;

import infnet.petshop.com.model.Vendedor;
import infnet.petshop.com.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping(value = "/vendedor/lista")
    public Collection<Vendedor> obterLista(){
        return vendedorService.obterLista();
    }

    @GetMapping(value =  "/vendedor/{id}")
    public Vendedor obterPorId(@PathVariable Integer id) {
        return vendedorService.obterPorId(id);
    }

    @PostMapping(value = "/vendedor/incluir")
    public void incluir(@RequestBody Vendedor vendedor) {
        vendedorService.incluir(vendedor);
    }

    @DeleteMapping(value = "/vendedor/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        vendedorService.excluir(id);
    }

    @GetMapping(value =  "/vendedor/{cpf}/cpf")
    public Vendedor obterPorCPF(@PathVariable String cpf) {
        return vendedorService.obterPorCPF(cpf);
    }
}