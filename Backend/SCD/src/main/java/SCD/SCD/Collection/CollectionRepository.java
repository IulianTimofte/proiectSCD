package SCD.SCD.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CollectionRepository extends CrudRepository<Collection, String> {
   // public Collection SaveCollectionById(String id);
    public Optional<Collection> getById(Long id);
    public Optional<Collection> getByName(String name);
    public void deleteById(Long id);

}
