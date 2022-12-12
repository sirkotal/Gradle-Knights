package pt.up.fe.ldts.gd.controller.town;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.state.WildState;

import java.io.IOException;

public class TownController extends Controller<Town> {
    public TownController(Town town) {
        super(town);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.OPT1) {
            // generate new items for shop, change graphics (enters shop)
        }
        else if (action == GUI.ACTION.OPT2) {
            game.setState(new WildState(new Wild(getModel().getPlayer())));
        }
        else if (action == GUI.ACTION.OPT3) {
            game.setState(new MenuState(new Menu()));
        }
    }
}

// jogo, shop, wild
