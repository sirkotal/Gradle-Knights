package pt.up.fe.ldts.gd.controller.wild;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.Fight;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.state.WildState;

import java.io.IOException;

public class FightController extends Controller<Fight> {
    public FightController(Fight fight){super(fight);}

    public void step (Game game, GUI.ACTION action) throws IOException{
        if(action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
        if(action == GUI.ACTION.OPT1) {
            game.setState(new WildState(new Wild(getModel().getPlayer())));
        }
        if(action == GUI.ACTION.OPT2) {
            getModel().resultFight();
            game.setState(new WildState(new Wild(getModel().getPlayer())));

        }
    }


}
