package SCD.SCD.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CollectionRepository extends CrudRepository<Collection, String> {
   // public Collection SaveCollectionById(String id);
    public boolean findById(Long id);
    public void deleteById(Long id);
}
