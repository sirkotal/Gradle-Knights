package pt.up.fe.ldts.gd.model.town;

public class CheapStrategy implements TownStrategy {
    public CheapStrategy() {}

    @Override
    public boolean buyItem(Shop shop, String itemName) {
        int spent = shop.buyItem(itemName, false);
        return spent != -1;
    }
}
