package SCD.SCD.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenSeaCollection {
    public String name;
    public OpenSeaStats stats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpenSeaStats getStats() {
        return stats;
    }

    public void setStats(OpenSeaStats stats) {
        this.stats = stats;
    }
}
