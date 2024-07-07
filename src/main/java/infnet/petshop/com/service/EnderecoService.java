package infnet.petshop.com.service;

import infnet.petshop.com.client.ApiVilardoClient;
import infnet.petshop.com.model.Endereco;
import infnet.petshop.com.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Collection<Endereco> obterLista() {
        return (Collection<Endereco>) enderecoRepository.findAll();
    }

    public long obterQtde() {
        return enderecoRepository.count();
    }


}
