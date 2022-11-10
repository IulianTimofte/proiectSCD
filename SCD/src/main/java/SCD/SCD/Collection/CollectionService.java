package SCD.SCD.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {
    @Autowired
    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public Collection createCollection(Collection collection){
        return collectionRepository.save(collection);
    }
    public List<Collection> getAllCollections(){
        List<Collection> collections = new ArrayList<>();
        collectionRepository.findAll().forEach(collections::add);
        return collections;
    }

    public Collection updateCollection(Collection collection){
        return collectionRepository.save(collection);
    }

    public Collection deleteCollection(Collection collection){
        collectionRepository.delete(collection);
        return collection;

    }


}
