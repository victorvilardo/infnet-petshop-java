package infnet.petshot.com.ApiVilardo.service;

import infnet.petshot.com.ApiVilardo.clients.EnderecoClient;
import infnet.petshot.com.ApiVilardo.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoClient enderecoClient;

    public Endereco obterPorCep(String cep) {
        return enderecoClient.obterPorCep(cep);
    }
}
