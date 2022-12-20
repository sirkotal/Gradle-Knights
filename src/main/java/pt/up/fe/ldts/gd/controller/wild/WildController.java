package pt.up.fe.ldts.gd.controller.wild;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.model.wild.Fight;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.FightState;
import pt.up.fe.ldts.gd.state.InventoryState;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.state.TownState;

import java.io.IOException;


public class WildController extends Controller<Wild> {
    public WildController(Wild wild) {
        super(wild);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
        if (action == GUI.ACTION.OPT1) {
            if(getModel().getEnemies().size() == 0) {
                game.setState(new TownState(new Town(getModel().getPlayer())));
            }
            else if(getModel().getPlayer().isAlive()) {
                game.setState(new FightState(new Fight(getModel().getPlayer(),getModel().getEnemies())));
            }
        }
        if(action == GUI.ACTION.OPT2) {
            if(getModel().getPlayer().isAlive())
                game.setState(new InventoryState(getModel().getPlayer().getInventory()));
        }
    }
}
