package pt.up.fe.ldts.gd.controller;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.model.menu.Menu;
import java.io.IOException;


public class WildController extends Controller<Wild> {
    private final PlayerController p1Controller;
    private final EnemyController enemiesController;
    public WildController(Wild wild) {
        super(wild);
        this.p1Controller = new PlayerController(wild);
        this.enemiesController = new EnemyController(wild);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.QUIT || !getModel().getPlayer().isAlive()) {
                game.setState(new MenuState(new Menu()));
        }
        else {
            p1Controller.step(game, action);
            enemiesController.step(game, action);
        }
    }
}
