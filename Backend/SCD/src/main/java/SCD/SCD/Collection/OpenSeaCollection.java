package SCD.SCD.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenSeaCollection {
    public OpenSeaStats stats;

    public OpenSeaStats getStats() {
        return stats;
    }

    public void setStats(OpenSeaStats stats) {
        this.stats = stats;
    }
}
