package SCD.SCD.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CollectionRepository extends CrudRepository<Collection, String> {
}
