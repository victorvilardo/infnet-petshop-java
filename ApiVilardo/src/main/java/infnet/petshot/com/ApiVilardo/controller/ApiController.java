package infnet.petshot.com.ApiVilardo.controller;

import infnet.petshot.com.ApiVilardo.model.Endereco;
import infnet.petshot.com.ApiVilardo.model.Estado;
import infnet.petshot.com.ApiVilardo.model.Municipio;
import infnet.petshot.com.ApiVilardo.service.EnderecoService;
import infnet.petshot.com.ApiVilardo.service.LocalidadeService;
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
    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep) {
        return enderecoService.obterPorCep(cep);
    }

    @GetMapping(value = "/estados")
    public Collection<Estado> obterEstados(){
        return localidadeService.obterEstados();
    }

    @GetMapping(value = "/{uf}/municipios")
    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf){
        return localidadeService.obterMunicipios(uf);
    }
}