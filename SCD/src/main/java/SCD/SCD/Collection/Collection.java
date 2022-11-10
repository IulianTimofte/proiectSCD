package SCD.SCD.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collection {
    private float floorPrice;
    private long totalSupply;
    private int numOwner;
    @Id
    private String name;
    private float totalVolume;
    private int sevenDaySales;
    public Collection(){

    }

    public Collection(float floorPrice, long totalSupply, int numOwner, String name, float totalVolume, int sevenDaySales) {
        this.floorPrice = floorPrice;
        this.totalSupply = totalSupply;
        this.numOwner = numOwner;
        this.name = name;
        this.totalVolume = totalVolume;
        this.sevenDaySales = sevenDaySales;
    }

    public float getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(float floorPrice) {
        this.floorPrice = floorPrice;
    }

    public long getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(long totalSupply) {
        this.totalSupply = totalSupply;
    }

    public int getNumOwner() {
        return numOwner;
    }

    public void setNumOwner(int numOwner) {
        this.numOwner = numOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(float totalVolume) {
        this.totalVolume = totalVolume;
    }

    public int getSevenDaySales() {
        return sevenDaySales;
    }

    public void setSevenDaySales(int sevenDaySales) {
        this.sevenDaySales = sevenDaySales;
    }
}
