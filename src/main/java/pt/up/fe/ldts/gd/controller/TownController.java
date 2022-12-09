package pt.up.fe.ldts.gd.controller;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.model.menu.Menu;
import java.io.IOException;

public class TownController extends Controller<Town> {
    public TownController(Town town) {
        super(town);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        /*if (action == GUI.ACTION.QUIT || getModel().getPlayer().isAlive()) {
                game.setState(new MenuState(new Menu()));
        }*/
    }
}
