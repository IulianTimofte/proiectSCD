package SCD.SCD.Collection;

import org.apache.catalina.LifecycleState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectionRepository extends CrudRepository<Collection, String> {
   // public Collection SaveCollectionById(String id);
}
