package SCD.SCD.Collection;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
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

    @DeleteMapping("/delete-collection/{id}")
    public String deleteCollection(@PathVariable String id) {
        return collectionService.deleteCollection(id);
    }

    @GetMapping("/get-opensea-collections")
    public String getOpenSeaCollections() throws IOException, InterruptedException, ParseException {
        return  collectionService.getOpenSeaCollection();
    }



   /* @RequestMapping(value = "/post")
    public String getPostResponse(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        RestTemplate restTemplate = null;
        return restTemplate.exchange("https://api.opensea.io/api/v1/collections?offset=0&limit=300", HttpMethod.POST,entity,String.class).getBody();
    }*/
}
