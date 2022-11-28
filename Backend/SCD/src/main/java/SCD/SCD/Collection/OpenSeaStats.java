package SCD.SCD.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenSeaStats {
    public Integer floor_price;
    public Integer total_supply;
    public Integer num_owners;
    public Integer total_volume;
    public Integer seven_day_sales;




    public Integer getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(Integer total_supply) {
        this.total_supply = total_supply;
    }

    public Integer getNum_owners() {
        return num_owners;
    }

    public void setNum_owners(Integer num_owners) {
        this.num_owners = num_owners;
    }

    public Integer getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(Integer total_volume) {
        this.total_volume = total_volume;
    }

    public Integer getSeven_day_sales() {
        return seven_day_sales;
    }

    public void setSeven_day_sales(Integer seven_day_sales) {
        this.seven_day_sales = seven_day_sales;
    }

    public Integer getFloor_price() {
        return floor_price;
    }

    public void setFloor_price(Integer floor_price) {
        this.floor_price = floor_price;
    }
}
