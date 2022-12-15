package pt.up.fe.ldts.gd.controller.player;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.CombatItem;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.state.WildState;

import java.io.IOException;

public class InventoryController extends Controller<Inventory> {
    private Player player;
    public InventoryController(Inventory inv) {
        super(inv);
        this.player = getModel().getPlayer();
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if(action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
        if(action == GUI.ACTION.OPT1 && player.getInventory().size() >= 1) {
            player.use(player.getInventory().getItems().get(0));
        }
        if(action == GUI.ACTION.OPT2 && player.getInventory().size() >= 2) {
            player.use(player.getInventory().getItems().get(1));
        }
        if(action == GUI.ACTION.OPT3 && player.getInventory().size() >= 3) {
            player.use(player.getInventory().getItems().get(2));
        }
        if(action == GUI.ACTION.OPT4 && player.getInventory().size() >= 4) {
            player.use(player.getInventory().getItems().get(3));
        }
        if(action == GUI.ACTION.OPT5 && player.getInventory().size() >= 5) {
            player.use(player.getInventory().getItems().get(4));
        }
        if(action == GUI.ACTION.OPT9) {
            game.setState(new WildState(new Wild(getModel().getPlayer())));
        }
    }
}
