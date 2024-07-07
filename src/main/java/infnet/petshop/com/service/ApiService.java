package infnet.petshop.com.service;

import infnet.petshop.com.client.ApiVilardoClient;
import infnet.petshop.com.model.Endereco;
import infnet.petshop.com.model.Estado;
import infnet.petshop.com.model.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class ApiService {

    @Autowired
    private ApiVilardoClient apiVilardoClient;

    public Endereco obterPorCep(String cep) {
        return apiVilardoClient.obterEnderecoPorCep(cep);
    }

    public Collection<Estado> obterEstados(){
        return apiVilardoClient.obterEstados();
    }

    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf){
        return apiVilardoClient.obterMunicipios(uf);
    }
}
