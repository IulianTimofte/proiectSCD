package SCD.SCD.Collection;

public class CollectionMapper {
    public static Collection toCollection(OpenSeaCollection openSeaCollection){
        Collection collection = new Collection();
        collection.setFloorPrice(openSeaCollection.getStats().getFloor_price());
        collection.setNumOwner(openSeaCollection.getStats().getNum_owners());
        collection.setTotalSupply(openSeaCollection.getStats().getTotal_supply());
        collection.setSevenDaySales(openSeaCollection.getStats().getSeven_day_sales());
        collection.setTotalVolume(openSeaCollection.getStats().getTotal_volume());
        collection.setName(openSeaCollection.getStats().getName());
        return  collection;
    }
}
