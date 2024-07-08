package infnet.petshop.com.client;

import infnet.petshop.com.model.Estado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "ibge")
public interface LocalidadeClient {

    @GetMapping(value = "/estados?orderBy=nome")
    Collection<Estado> obterEstados();

}
