package infnet.petshot.com.ApiVilardo.controller;

import infnet.petshot.com.ApiVilardo.model.Endereco;
import infnet.petshot.com.ApiVilardo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RestController
public class ApiController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/listagem")
    public Collection<String> obterLista(){
        return new ArrayList<String>(
                Arrays.asList("Victor", "Pereira", "Vilardo")
        );
    }

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep) {
        return enderecoService.obterPorCep(cep);
    }
}
