package infnet.petshop.com.service;

import infnet.petshop.com.client.ApiVilardoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ApiService {

    @Autowired
    private ApiVilardoClient apiVilardoClient;

    public Collection<String> obterLista() {
        return apiVilardoClient.obterLista();
    }
}
