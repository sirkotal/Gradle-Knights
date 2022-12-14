package pt.up.fe.ldts.gd.controller.wild;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;

import java.io.IOException;


public class WildFightController extends WildController {
    public WildFightController(Wild wild) {
        super(wild);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
        else if (action == GUI.ACTION.OPT1 && getModel().getPlayer().isAlive()) {
            getModel().fight(getModel().getPlayer());
        }
    }
}
