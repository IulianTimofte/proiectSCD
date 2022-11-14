package SCD.SCD.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenSeaCollections {
    private List<OpenSeaCollection> collections;

    public List<OpenSeaCollection> getCollections() {
        return collections;
    }

    public void setCollections(List<OpenSeaCollection> collections) {
        this.collections = collections;
    }
}
