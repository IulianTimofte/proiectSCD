package SCD.SCD.Collection;


import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.springframework.http.HttpStatus.REQUEST_TIMEOUT;

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

        return collectionRepository.save(collection);
    }

    public String deleteCollection(String id )  {
        if(!collectionRepository.existsById(id)){
            throw new RuntimeException("collection not exist");
        }
        collectionRepository.deleteById(id);
        return "Collection with id "+id+" has been deleted with success.";

    }
   public String getOpenSeaCollection() throws IOException, InterruptedException, JSONException, ParseException {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://api.opensea.io/api/v1/collections?offset=0&limit=300")
//                .get()
//                .addHeader("accept", "application/json")
//                .build();
//
//        Response response = client.newCall(request).execute();

       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create("https://api.opensea.io/api/v1/collections?offset=0&limit=300"))
               .method("GET", HttpRequest.BodyPublishers.noBody())
               .build();

       HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
       JSONParser parser = new JSONParser();
       JSONObject json = (JSONObject) parser.parse(response.body());
     //  JSONObject yourJsonObject = (JSONObject) new JSONParser(response.body()).parse();
       JSONObject data = (JSONObject) json.get("collections");
       JSONObject data0 = (JSONObject) data.get(String.valueOf(0));
       JSONObject another_data = (JSONObject) data0.get("stats");

       String required_field1 = another_data.get("floor_price").toString();
       String required_field2 = another_data.get("required_field2").toString();
       return required_field1;
    }




}
