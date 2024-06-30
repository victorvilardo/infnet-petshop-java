package infnet.petshot.com.ApiVilardo.service;

import infnet.petshot.com.ApiVilardo.clients.LocalidadeClient;
import infnet.petshot.com.ApiVilardo.model.Estado;
import infnet.petshot.com.ApiVilardo.model.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeClient localidadeClient;

    public Collection<Estado> obterEstados(){
        return localidadeClient.obterEstados();
    }

    public Collection<Municipio> obterMunicipios(Integer uf){
        return localidadeClient.obterMunicipios(uf);
    }
}
