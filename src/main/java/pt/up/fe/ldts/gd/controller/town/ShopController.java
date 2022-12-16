package pt.up.fe.ldts.gd.controller.town;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.town.Shop;
import pt.up.fe.ldts.gd.model.town.ShopStrategy;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.state.TownState;

import java.io.IOException;
import java.util.List;

public class ShopController extends Controller<Shop> {
    private Player player;
    private List<Item> items;
    private ShopStrategy strategy;
    public ShopController(Shop shop) {
        super(shop);
        this.player = getModel().getPlayer();
        this.items = getModel().getItems();
        this.strategy = getModel().getStrategy();
    }

    @Override
    public void step(Game game, GUI.ACTION action) throws IOException {
        if(action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
        if(action == GUI.ACTION.OPT9) {
            // BUG: resets shop strategy when leaving to town (solution idea: pass town as parameter for ShopState)
            game.setState(new TownState(new Town(getModel())));
        }
        if(action == GUI.ACTION.OPT1 && items.size() >= 1) {
            strategy.buyItem(items.get(0), player);
        }
        if(action == GUI.ACTION.OPT2 && items.size() >= 2) {
            strategy.buyItem(items.get(1), player);
        }
        if(action == GUI.ACTION.OPT3 && items.size() >= 3) {
            strategy.buyItem(items.get(2), player);
        }
        if(action == GUI.ACTION.OPT4 && items.size() >= 4) {
            strategy.buyItem(items.get(3), player);
        }
        if(action == GUI.ACTION.OPT5 && items.size() >= 5) {
            strategy.buyItem(items.get(4), player);
        }
    }
}
