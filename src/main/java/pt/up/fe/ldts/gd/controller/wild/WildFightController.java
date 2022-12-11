package pt.up.fe.ldts.gd.controller.wild;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.controller.Controller;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.model.menu.Menu;
import java.io.IOException;


public class WildFightController extends WildController {
    private final PlayerController p1Controller;
    private final EnemyController enemiesController;
    public WildFightController(Wild wild) {
        super(wild);
        this.p1Controller = new PlayerController(wild);
        this.enemiesController = new EnemyController(wild);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.OPTION3 || !getModel().getPlayer().isAlive()) {
            game.setState(new MenuState(new Menu()));
        }
        else {
            p1Controller.step(game, action);
            enemiesController.step(game, action);
        }
    }
}
