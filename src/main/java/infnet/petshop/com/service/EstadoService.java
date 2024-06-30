package infnet.petshop.com.service;

import infnet.petshop.com.client.LocalidadeClient;
import infnet.petshop.com.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class EstadoService {

    @Autowired
    private LocalidadeClient localidadeClient;

    public Collection<Estado> obterLista(){

        return localidadeClient.obterEstados();
    }
}
