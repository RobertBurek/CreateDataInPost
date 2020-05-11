package pl.maestrofinansow.inpostmap;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaczkomatRepository extends CrudRepository<Paczkomat,Long> {
}
