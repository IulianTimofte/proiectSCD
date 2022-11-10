package SCD.SCD.Collection;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @PostMapping("/create-collection")
    public Collection createCollection(@RequestBody Collection collection){
        return collectionService.createCollection(collection);
    }


    @GetMapping("/get-collections")
    public List<Collection> getAllCollections(){
        return collectionService.getAllCollections();
    }

    @PutMapping("/update-collection")
    public Collection updateCollection(@RequestBody Collection collection){
        return collectionService.updateCollection(collection);
    }

    @DeleteMapping("/delete-collection")
    public Collection deleteCollection(@RequestBody Collection collection){
        return  collectionService.deleteCollection(collection);
    }

}
