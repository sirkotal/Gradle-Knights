package pt.up.fe.ldts.gd.controller.town;

import com.googlecode.lanterna.input.KeyType;
import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.town.Town;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.model.menu.Menu;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import pt.up.fe.ldts.gd.state.WildState;
import pt.up.fe.ldts.gd.model.wild.Wild;

import java.io.IOException;

public class TownController extends Controller<Town> {
    public TownController(Town town) {
        super(town);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.OPTION1) {
            // generate new items for shop, change graphics (enters shop)
        }
        else if (action == GUI.ACTION.OPTION2) {
            game.setState(new WildState(new Wild(new Player("Heisenberg")))); // temporary!!!
        }
        else if (action == GUI.ACTION.OPTION3) {
            game.setState(new MenuState(new Menu()));
        }
    }
}

// jogo, shop, wild
