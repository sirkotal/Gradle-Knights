package pt.up.fe.ldts.gd.controller.player;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.Inventory;
import pt.up.fe.ldts.gd.state.MenuState;

import java.io.IOException;

public class InventoryController extends Controller<Inventory> {
    public InventoryController(Inventory inv) {
        super(inv);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if(action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
    }
}
