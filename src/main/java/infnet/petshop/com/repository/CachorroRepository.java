package infnet.petshop.com.repository;

import infnet.petshop.com.model.Cachorro;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface CachorroRepository  extends CrudRepository<Cachorro, Integer> {

    Collection<Cachorro> findAll(Sort by);

    Collection<Cachorro> findByAdestrado(boolean adestrado);

    Collection<Cachorro> findByPorte(String porte);
}
