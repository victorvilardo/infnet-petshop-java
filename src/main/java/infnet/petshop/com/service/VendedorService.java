package infnet.petshop.com.service;

import infnet.petshop.com.model.Vendedor;

import java.util.Collection;


import infnet.petshop.com.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public void incluir(Vendedor vendedor){
        try {
            vendedorRepository.save(vendedor);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    public Collection<Vendedor> obterLista(){
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }

    public Vendedor obterPorId(Integer id) {
        return vendedorRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        vendedorRepository.deleteById(id);
    }

    public long obterQtde() {
        return vendedorRepository.count();
    }

    public Vendedor obterPorCPF(String cpf) {
        return vendedorRepository.findByCpf(cpf);
    }
}

