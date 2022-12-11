package pt.up.fe.ldts.gd.controller.wild;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.model.wild.Enemy;
import java.io.IOException;

public class EnemyController extends WildController {

    public EnemyController(Wild wild) {
        super(wild);
    }

    @Override
    public void step(Game game, GUI.ACTION action) throws IOException {
        for (Enemy enemy : getModel().getEnemies()) {
            if (enemy.isTurn()) {
                attackPlayer(enemy);
                enemy.setTurn(false);
            }
        }
    }

    private void attackPlayer(Enemy enemy) {
        /* to implement */
    }
}
