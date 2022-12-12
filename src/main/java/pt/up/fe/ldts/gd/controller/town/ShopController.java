package pt.up.fe.ldts.gd.controller.town;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.town.Shop;
import pt.up.fe.ldts.gd.state.MenuState;

import java.io.IOException;

public class ShopController extends Controller<Shop> {
    public ShopController(Shop shop) {
        super(shop);
    }

    @Override
    public void step(Game game, GUI.ACTION action) throws IOException {
        if(action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
    }
}
