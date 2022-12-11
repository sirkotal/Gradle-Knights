package pt.up.fe.ldts.gd.controller.wild;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.model.menu.Menu;
import java.io.IOException;


public abstract class WildController extends Controller<Wild> {
    public WildController(Wild wild) {
        super(wild);
    }
}
