package infnet.petshop.com.repository;

import infnet.petshop.com.model.Gato;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface GatoRepository  extends CrudRepository<Gato, Integer> {

    Collection<Gato> findAll(Sort by);


    Collection<Gato> findByTipoPelagemContaining(String tipoPelagem);
}

