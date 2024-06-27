package infnet.petshop.com.repository;

import infnet.petshop.com.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface AnimalRepository  extends CrudRepository<Animal, Integer> {


    Collection<Animal> findByVendedorId(Integer id);
}
