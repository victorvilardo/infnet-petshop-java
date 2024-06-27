package infnet.petshop.com.repository;

import infnet.petshop.com.model.Vendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendedorRepository  extends CrudRepository<Vendedor, Integer> {

    Vendedor findByCpf(String cpf);

}
