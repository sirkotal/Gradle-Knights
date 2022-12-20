package pt.up.fe.ldts.gd.controller.wild;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.wild.Fight;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;

import java.io.IOException;

public class FightController extends Controller<Fight> {
    public FightController(Fight fight){super(fight);}

    public void step (Game game, GUI.ACTION action) throws IOException{
        if(action == GUI.ACTION.OPT0) {
            game.setState(new MenuState(new Menu()));
        }
        if(action == GUI.ACTION.OPT1) {
            if(game.getPreviousState().getModel() instanceof Wild) {
                ((Wild) game.getPreviousState().getModel()).setMessage("You fled from the fight");
                game.setState(game.getPreviousState());
            }
        }
        if(action == GUI.ACTION.OPT2) {
            int loot = getModel().resultFight();
            if(game.getPreviousState().getModel() instanceof Wild) {
                ((Wild) game.getPreviousState().getModel()).setMessage(
                        "You fought an enemy and you won! You earned " + loot + " gold!"
                );
                game.setState(game.getPreviousState());
            }
        }
    }
}
