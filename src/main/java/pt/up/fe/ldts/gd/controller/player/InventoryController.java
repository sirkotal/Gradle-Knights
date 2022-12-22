package pt.up.fe.ldts.gd.controller.player;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.state.menu.MenuState;

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
        if(action == GUI.ACTION.OPT1 && getModel().size() >= 1) {
            player.use(getModel().getItem(0));
        }
        if(action == GUI.ACTION.OPT2 && getModel().size() >= 2) {
            player.use(getModel().getItem(1));
        }
        if(action == GUI.ACTION.OPT3 && getModel().size() >= 3) {
            player.use(getModel().getItem(2));
        }
        if(action == GUI.ACTION.OPT4 && getModel().size() >= 4) {
            player.use(getModel().getItem(3));
        }
        if(action == GUI.ACTION.OPT5 && getModel().size() >= 5) {
            player.use(getModel().getItem(4));
        }
        if(action == GUI.ACTION.OPT9) {
            game.setState(game.getPreviousState());
        }
    }
}
