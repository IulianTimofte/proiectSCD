package SCD.SCD.Collection;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService<OkHttpClient> {
//    @Bean
//    public WebClient localApiClient() {
//        return WebClient.create("https://api.opensea.io/api/v1/collections?offset=0&limit=300");
//    }


    //@Autowired
    //private final WebClient localApiClient;
    private final CollectionRepository collectionRepository;


    public CollectionService( CollectionRepository collectionRepository) {

        this.collectionRepository = collectionRepository;
    }
//    public Collection getCollection() {
//        return localApiClient
//                .get()
//                .uri("/collections/" )
//                .retrieve()
//                .bodyToMono(Collection.class)
//                .block();
//    }

    public Collection createCollection(Collection collection){
        return collectionRepository.save(collection);
    }
    public List<Collection> getAllCollections(){

       return (List<Collection>) collectionRepository.findAll();

    }

    public Collection updateCollection(Collection collection){
        if(!collectionRepository.findById(collection.getId())){
            throw new RuntimeException("collection not exist");
        }
        return collectionRepository.save(collection);
    }

    public String deleteCollection(Long id )  {
        if(!collectionRepository.findById(id)){
            throw new RuntimeException("collection not exist");
        }
        collectionRepository.deleteById(id);
        return "Collection with id "+id+" has been deleted with success.";

    }
   public ArrayList<Collection> getOpenSeaCollection() throws IOException, InterruptedException, JSONException, ParseException {
       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create("https://api.opensea.io/api/v1/collections?offset=0&limit=300"))
               .method("GET", HttpRequest.BodyPublishers.noBody())
               .build();

       HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
       OpenSeaCollections openSeaCollections = new ObjectMapper().readValue(response.body(), OpenSeaCollections.class);
       System.out.println(openSeaCollections.getCollections().get(0).getStats().getFloor_price());
       System.out.println(openSeaCollections.getCollections().get(0).getStats().getTotal_volume());
       System.out.println(openSeaCollections.getCollections().get(0).getStats().getTotal_supply());
       System.out.println(openSeaCollections.getCollections().get(0).getStats().getNum_owners());
       System.out.println(openSeaCollections.getCollections().get(0).getStats().getSeven_day_sales());
       System.out.println(openSeaCollections.getCollections().get(0).getName());
       ArrayList<Collection> collections = new ArrayList<>();
       openSeaCollections.getCollections().forEach(openSeaCollection -> collections.add(CollectionMapper.toCollection(openSeaCollection)));
       collections.forEach(collectionRepository::save);
       return collections;


    }




}
