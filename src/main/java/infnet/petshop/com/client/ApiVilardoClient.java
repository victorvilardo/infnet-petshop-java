package infnet.petshop.com.client;


import infnet.petshop.com.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "http://localhost:8081", name = "apiElberth")
public interface ApiVilardoClient {

    @GetMapping(value = "/listagem")
    Collection<String> obterLista();

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep);
}