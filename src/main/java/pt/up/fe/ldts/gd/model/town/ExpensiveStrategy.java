package pt.up.fe.ldts.gd.model.town;

public class ExpensiveStrategy implements TownStrategy {
    public ExpensiveStrategy() {}

    @Override
    public boolean buyItem(Shop shop, String itemName) {
        int spent = shop.buyItem(itemName, true);
        return spent != -1;
    }
}
